import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
지도에 주어진 cctv의 방향을 조작 > 사각지대 최소 크기
- 백트래킹

- 
*/

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    static int[] machine = new int[3];
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 청소기 {x, y, d}
        machine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        arr = new int[n][m];
        for (int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        search();
        
        System.out.println(answer);

    }
    
    public static void search() {
        while (true) {
                
            // 현재 칸 청소
            if (arr[machine[0]][machine[1]] == 0) {
                // System.out.println("x: " + machine[0] + " y: " + machine[1] + " d: " + machine[2]);
                
                arr[machine[0]][machine[1]] = 2;
                answer++;
            }
            
            // 90 도 회전
            int cnt = spin();
            
            // 앞 칸에 빈칸이 있는 경우 -> continue
            if (cnt <= 4 && arr[machine[0]][machine[1]] == 0 ) continue;
            
            // 회전을 다 돌았는데, 빈 칸이 없는 경우 -> 후진
            int d = machine[2];
            int cx = machine[0] - pos[d][0];
            int cy = machine[1] - pos[d][1];

            // 후진을 못하는 경우 -> 종료
            if (cx < 0 || cx >= n || cy < 0 || cy >= m) return;
            if (arr[cx][cy] == 1) return;

            machine[0] = cx;
            machine[1] = cy;
            machine[2] = d;

        }
    }
    
    // 반시계 방향 회전 > 앞에 칸이 청소 안한 빈칸인지 확인
    // 청소 안한 빈칸 일 경우, 해당 칸으로 이동 -> return cnt
    // 청소 안한 빈칸이 없을 경우 -> return cnt
    public static int spin() {
        int cnt = 0; // 회전 횟수
        int d = machine[2];
        
        while (cnt < 4) {
            cnt++;
            d =  d > 0 ? d-1: 3;
            // System.out.println("cnt: " + cnt + " d: " + d);
            int cx = machine[0] + pos[d][0];
            int cy = machine[1] + pos[d][1];

            if (cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
            
            if (arr[cx][cy] == 0) {
                machine[0] = cx;
                machine[1] = cy;
                machine[2] = d;
                break;
            }
        } 
        
        return cnt;
    }
}
