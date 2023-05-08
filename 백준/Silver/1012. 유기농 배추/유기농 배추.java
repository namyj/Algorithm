// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;

// 최소 지렁이 개수
// - 시작점을 찾아서 bfs 로 방문 > 그래프 내 모든 점을 방문할 때까지
// > 시작점의 개수 출력
public class Main {
    public static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        while (t > 0) {
            t--;
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // 배추 개수
            
            int[][] arr = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            
            for (int i=0; i < k ; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); 
                int y = Integer.parseInt(st.nextToken()); 
                
                arr[x][y] = 1;
            }
            
            Queue<Integer[]> q = new LinkedList<>();
            int cnt = 0; // 결과, 지렁이 수
            
            for (int i=0; i < m ; i++) { 
                for (int j=0; j < n; j++) {
                    if (arr[i][j] == 0 || visited[i][j]) continue;
                    
                    // 시작점
                    q.add(new Integer[] {i, j});
                    visited[i][j] = true;
                    cnt++;
                    
                    while (!q.isEmpty()) {
                        Integer[] curNode = q.poll();
                        int x = curNode[0];
                        int y = curNode[1];
                        for (int z=0; z < pos.length; z++) {
                            int nx = x + pos[z][0];
                            int ny = y + pos[z][1];
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if (arr[nx][ny] == 0 || visited[nx][ny]) continue;
                            
                            q.add(new Integer[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                    
                }
            
            
            }
            
            bw.write(cnt + "\n");
            
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}