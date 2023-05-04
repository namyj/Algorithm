import java.util.*;
import java.io.*;

public class Main {
    static int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] nmArr = br.readLine().split(" ");
        int n = Integer.parseInt(nmArr[0]); // 정점 수
        int m = Integer.parseInt(nmArr[1]); // 간선 수
        
        int[][] arr = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        
        for (int i=1; i <= n; i++) {
            String input = br.readLine();
            for (int j=1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(input.charAt(j-1) + "");
            }
        }
        
        // 3. bfs 수행
        Queue<int[]> q = new LinkedList<>();
        int result = 0; // 칸 수

        visited[1][1] = true;
        q.add(new int[] {1, 1});
        
        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int cx = curNode[0];
            int cy = curNode[1];
            visited[cx][cy] = true;
            
            for (int i=0; i < pos.length; i++) {
                int nx = cx + pos[i][0];
                int ny = cy + pos[i][1];
                
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && !visited[nx][ny] && arr[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    arr[nx][ny] = arr[cx][cy] + 1; // 시작노드에서 해당 노드까지 depth 기록
                }
            }  
        }
        
        // 출력
        bw.write(arr[n][m] + "");
        
        bw.flush();
        bw.close();
        br.close();
    }
}