import java.util.*;
import java.io.*;


public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] copy;
    static ArrayList<int[]> cctvList; // {type, x, y}
    static int result = Integer.MAX_VALUE;
    static int[] dir;
    static int[][] pos = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        cctvList = new ArrayList<int[]>();
        
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                
                if (tmp % 6 > 0) {
                    cctvList.add(new int[]{tmp, i, j});
                }
            }
        }
        
        dir  = new int[cctvList.size()];
        
        search(0);   
        
        System.out.println(result);
    } 
    
    public static void search(int r) {
        // 모든 CCTV 방향 선택 완료 > 감시 표시
        if (r == cctvList.size()) {
            copy = new int[n][m];
            for (int i=0; i < n; i++) {
                copy[i] = Arrays.copyOf(arr[i], arr[i].length);
            }
            
            for (int i=0; i < cctvList.size(); i++) {
                int[] cctv = cctvList.get(i);
                direction(cctv, dir[i]);
            }
            
            // 사각지대 카운트
            count();
            return;
        }
        
        // CCTV 방향 선택
        for (int d = 0; d < 4; d++) {
            dir[r] = d;
            search(r+1);
        }
    }
    
    // d : 상 우 하 좌 0, 1, 2, 3
    public static void direction(int[] cctv, int d) {
        switch(cctv[0]) {
            case 1:
                watch(cctv, d);
                break;
            case 2:
                watch(cctv, d);
                watch(cctv, (d+2)%4);
                break;
            case 3:
                watch(cctv, d);
                watch(cctv, (d+1)%4);
                break;
            case 4:
                watch(cctv, d);
                watch(cctv, (d+1)%4);
                watch(cctv, (d+2)%4);
                break;
            case 5:
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
                break;
            default: 
                return;
        }
    }
    
    // 감시 표시 (인접 노드 방문)
    public static void watch(int[] cctv, int d) {
        int nx = cctv[1];
        int ny = cctv[2];
        copy[nx][ny] = cctv[0];
        
        while (true) {
            nx = nx + pos[d][0];
            ny = ny + pos[d][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) return;
            if (copy[nx][ny] == 6) return;
            if (copy[nx][ny] != 0) continue; // CCTV 통과 가능

            copy[nx][ny] = cctv[0];
        }
    }
    
    // 사각지대 카운트
    public static void count() {
        int cnt = 0;
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (copy[i][j] == 0) cnt++;
            }
        }
        
        result = Math.min(result, cnt);
    }
}
