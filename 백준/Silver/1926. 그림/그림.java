import java.io.*;
import java.util.*;
// 접근법
// 1. 그래프를 돌면서 시작점 노드를 찾기 (그림의 개수)
// 2. 시작점 노드에서 bfs 수행 (그림의 넓이)
public class Main {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] graph;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동
    
    static int bfs (int x, int y) {
        int width = 0;
        
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>(); // 노드(x, y)를 저장하기 위해 큐의 원소를 배열로 생성
        q.add(new int[]{x,y}); 
        width++;
        
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int cx = arr[0];
            int cy = arr[1];
            
            for (int i=0; i < pos.length; i++) {
                int nx = cx + pos[i][0];
                int ny = cy + pos[i][1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && !visited[nx][ny]) {
                    width++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return width;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n][m];
        graph = new int[n][m];
        
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max = 0;
        int cnt = 0;
        
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) { // 시작점 노드
                    cnt++;
                    int width = bfs(i, j);
                    max = Math.max(max, width);
                }
            }
        }
        
        bw.write(String.valueOf(cnt) + "\n");
        bw.write(String.valueOf(max) + "\n");
        
        bw.flush();
        bw.close();
        br.close();
        
        
        
    }
}