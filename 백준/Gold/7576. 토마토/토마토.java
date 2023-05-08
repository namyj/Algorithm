// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;

// 출력: 토마토가 전부 익을 때까지 걸리는 최소 일수
// 처음부터 모든 토마토 익어있음 > 0 / 토마토가 모두 익지 못하는 상황 > -1

public class Main {
    public static int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int[][] arr = new int[n][m];
        
        // 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토 없는 칸 
        Queue<int[]> q = new LinkedList<>();
        int day = 0; // 결과, 일 수
        int numZero = 0; // 방문해야하는 칸 수 (1, 0의 수)
        
        for (int i=0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            for (int j=0; j < m ; j++) {
                if (arr[i][j] == -1) continue;
                
                // 시작점 먼저 저장 > 최소 일수를 구하기 위해
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j, day});
                } 
                numZero++;
            }
        }
        
        // bfs
        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int x = curNode[0];
            int y = curNode[1];
            day = curNode[2];
            numZero--;

            for (int k=0; k < pos.length; k++) {
                int nx = x + pos[k][0];
                int ny = y+ pos[k][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (arr[nx][ny] != 0) continue; // 방문할 필요 X
                arr[nx][ny] = 1;
                q.add(new int[] {nx, ny, day + 1});
            }
        }

        if (numZero > 0) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
        
    }
}