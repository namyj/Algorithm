import java.io.*;
import java.util.*;

/*
4가지 면이 인접한 도형이 맵에 놓임 > 놓인 칸에 적힌 수 합의 최대값

- 4 개 인접한 칸 정하기 > bfs
- bfs로는 ㅗ, ㅜ 형태 불가능 
    1. 4 방향에서 x, y에 인접한 칸 선택 - bfs 수행, 선택 유지
    2. 4 방향에서 x, y에 인접한 칸 하나더 선택 - bfs 수행, 선택 해제
    3. 1번 선택 해제
*/
public class Main {
    static int n, m;
    static int[][] arr;
    static int max = 0;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static int[][] poly;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i=0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        search();
        
        System.out.println(max);
        
        br.close();
    }
    
    // 시작점 -> bfs
    public static void search() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                poly = new int[4][2];

                visited[i][j] = true;                
                poly[0] = new int[] {i, j};
                
                bfs(i, j, 1);
                visited[i][j] = false;
            }
        }
    }
    
    public static void bfs(int x, int y, int k) {
        // 4개 칸 선택 완료 > 합 구하기, max 비교
        if (k >= 4) {
            int sum = 0;
            
            for (int i=0; i < 4; i++) {
                sum += arr[poly[i][0]][poly[i][1]];
            }
            
            // if (max < sum) {
            //     System.out.print("sum : " + sum + " poly: ");
            //     for (int i=0; i<poly.length; i++) {
            //         System.out.print(Arrays.toString(poly[i]) + " ");
            //     }
            //     System.out.println();
            // }
            max = Math.max(sum, max);
            return;
        }
        
        // 4 개 칸 선택
        
        for (int i=0; i < 4; i++) {
            int cx = x + pos[i][0];
            int cy = y + pos[i][1];

            if (cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
            if (visited[cx][cy]) continue;

            visited[cx][cy] = true;
            poly[k] = new int[]{cx, cy};
            bfs(cx, cy, k + 1);
            
            // 인접한 칸 하나 더 선택하는 경우
            if (k < 3) {
                for (int j=0; j<4; j++) {
                    int nx = x + pos[j][0];
                    int ny = y + pos[j][1];
                    
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (visited[nx][ny]) continue;
                    
                    visited[nx][ny] = true;
                    poly[k+1] = new int[]{nx, ny};
                    bfs(nx, ny, k + 2);
                    visited[nx][ny] = false;
                }
            }
            
            visited[cx][cy] = false;
        }   
    }

}
