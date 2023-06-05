import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] copy;
    
    static boolean[][] visited;
    static boolean[][] bVisited;
    static int[][] pos = {{0, 1},{0, -1}, {1, 0}, {-1, 0}};
    
    static int answer = 0;
    static LinkedList<int[]> virus;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        
        virus = new LinkedList<>();
        
        for (int i=0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            for (int j=0; j < m; j++) {
                if (arr[i][j] == 2) { // 바이러스 위치
                    virus.add(new int[]{i, j});
                }
            }
        }
    
        search(0);
        
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
    
    /*
    벽 3 개 선택 > 바이러스 bfs
    */
    public static void search(int k) {
        if (k == 3) {
            // arr 복사본
            bVisited = new boolean[n][m];
            copy = new int[n][m];
            for (int i=0; i < n; i++) {
                copy[i] = Arrays.copyOf(arr[i], arr[i].length);
            }
            
            // 바이러스 bfs
            Iterator<int[]> iter = virus.iterator();
            while(iter.hasNext()) {
                int[] curNode = iter.next();
                bfs(curNode[0], curNode[1]);   
            }
            
            // 안전 영역 계산
            calc();
            return;
        }
        
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (visited[i][j]) continue;
                if (arr[i][j] != 0) continue;
                
                visited[i][j] = true;
                arr[i][j] = 1;
                search(k+1);
                
                arr[i][j] = 0;
                visited[i][j] = false;
            }
        }
    }
    
    
    /*
    바이러스 이동
    - 각 바이러스에 대해서 bfs
    - 안전 영역 카운트
    */
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x, y});
        bVisited[x][y] = true;

        while(!q.isEmpty()) {
            int[] curNode = q.poll();

            for (int i=0; i <4; i++) {
                int nx = curNode[0] + pos[i][0];
                int ny = curNode[1] + pos[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (bVisited[nx][ny]) continue;
                if (copy[nx][ny] != 0) continue;

                bVisited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                copy[nx][ny] = 2;
            }
        }
      
    }
    
    public static void calc() {
        int cnt = 0;
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if(copy[i][j] == 0) cnt++;
            }
        }
        
        max = Math.max(max, cnt);
    }
}
