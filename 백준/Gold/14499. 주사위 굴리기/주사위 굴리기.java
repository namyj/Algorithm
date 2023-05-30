import java.io.*;
import java.util.*;

/*
주의!!
- map 칸 값이 0이 아닐 때 > 주사위로 복사 & 칸 값 0으로 바꿔주기!!!
*/
public class Main {
    static BufferedWriter bw;
    static int n; 
    static int m;
    static int[][] map;
    static int x, y, k;
    static int[] arr1 = new int[4];
    static int[] arr2 = new int[4];
    static int[][] pos = {{0, 1}, {0, -1}, {-1, 0,}, {1, 0}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for(int i=0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            move(dir);
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
    
    public static void move(int d) throws IOException{
        // 주사위 칸 이동
        int cx = x + pos[d-1][0];
        int cy = y + pos[d-1][1];
        
        // 주사위가 칸을 벗어나는 경우
        if (cx < 0 || cx >= n || cy < 0 || cy >= m) return;
        
        x = cx; y = cy;
        
        // 동, 서 -> arr1
        // 북, 남 -> arr2
        int before, tmp;
        switch (d) {
            case 1:
                before = arr1[3];
                for (int i=0; i < 4; i++) {
                    tmp = arr1[i];
                    arr1[i] = before;
                    before = tmp;
                }
                break;
            case 2:
                before = arr1[0];
                for (int i=3; i >= 0; i--) {
                    tmp = arr1[i];
                    arr1[i] = before;
                    before = tmp;
                }
                break;
            case 3:
                before = arr2[0];
                for (int i=3; i >= 0; i--) {
                    tmp = arr2[i];
                    arr2[i] = before;
                    before = tmp;
                }
                break;
            case 4:
                before = arr2[3];
                for (int i=0; i < 4; i++) {
                    tmp = arr2[i];
                    arr2[i] = before;
                    before = tmp;
                }
                break;
            default:
                return;
        }
        
        // arr1과 arr2의 윗면, 아랫면 일치시키기
        if (d > 2) {
            arr1[1] = arr2[1];
            arr1[3] = arr2[3];
        } else {
            arr2[1] = arr1[1];
            arr2[3] = arr1[3];
        }
        
        if (map[x][y] == 0) {
            map[x][y] = arr1[3];
        } else {
            arr1[3] = map[x][y];
            arr2[3] = map[x][y];
            map[x][y] = 0; // 주의!!
        }
        
        bw.write(arr1[1] + "\n");
    }
}