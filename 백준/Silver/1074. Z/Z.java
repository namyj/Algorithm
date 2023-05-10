import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int n;
    public static int r;
    public static int c;
    public static int[][] pos = {{0,0}, {0,1},{1,0},{1,1}}; // 방문 순서
    
    public static int cnt = -1; // 결과
    
    // x, y : 시작점, n : 원소 개수 (2의 몇 제곱인지)
    public static void visitZ(int x, int y, int n) throws IOException {
        
        if (n==1) { // 방문
            int nx; int ny;
            
            for (int i=0; i < pos.length; i++) {
                cnt++;
                nx = x + pos[i][0];
                ny = y + pos[i][1];
                
                if (nx == r && ny == c) {
                    bw.write(cnt +"");
                }
            }
            return;
        }
        
        // 분할 방문
        // 모든 칸을 방문하면 시간 초과 > R과 C 를 포함하는 것만 방문
        int mid = (int) Math.pow(2, n-1);
        
        if (r >= x && r < x+mid && c >= y && c < y+mid ) {  
            visitZ(x, y, n-1);
        } 
        
        cnt += mid*mid;
        if (r >= x && r < x+mid && c >= y+mid ) {
            visitZ(x, y + mid, n-1);
        }
        
        cnt += mid*mid;
        if (r >= x+mid && c >= y && c < y+mid ) {
            visitZ(x + mid, y, n-1);
        } 
        
        cnt += mid*mid;
        if (r >= x+mid && c >= y+mid ) {
            visitZ(x + mid, y + mid, n-1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); 
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        visitZ(0, 0, n);
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}