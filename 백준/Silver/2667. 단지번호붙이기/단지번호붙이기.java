// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}}; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n]; 
        boolean[][] visited = new boolean[n][n];
        List<Integer> result = new ArrayList<>();
        
        for (int i=0; i < n; i++) {
            // 입력된 문자열(스트림) > 각 문자로 분할 > 정수 변환 > 배열 변환
            // "0110100" >  [0, 1, 1, 0, 1, 0, 0]
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                if (arr[i][j] == 0 || visited[i][j]) continue;
                
                // 시작점
                int cntH = 0; // 단지 내 집 개수
                Queue<int[]> q = new LinkedList<>();
                
                visited[i][j] = true;
                q.add(new int[] {i, j});
                
                while (!q.isEmpty()) {
                    int[] curNode = q.poll();
                    cntH++;
                    
                    int x = curNode[0];
                    int y = curNode[1];
                    
                    for (int k=0; k < pos.length ; k++) {
                        int nx = x + pos[k][0];
                        int ny = y + pos[k][1];
                        
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (arr[nx][ny] == 0 || visited[nx][ny]) continue;
                        
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
                
                result.add(cntH);        
            }
        }
        
        Collections.sort(result);
        
        bw.write(result.size() + "\n");
        for (int cnt: result)
            bw.write(cnt + "\n");
    
        bw.flush();
        bw.close();
        br.close();
        
    }
}