import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
- 머리 이동 후 > 꼬리 줄이기
    따라서 꼬리를 줄이기 전에 자기 자신을 만날 수 있다.
- 마지막 회전 이후 search 필요
*/
public class Main {
    static int n, k, l;
    static int d;
    static int[][] arr;
    static LinkedList<int[]> snake = new LinkedList<>(); // 뱀이 있는 {x, y, 방향} 저장
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};// 오른, 아래, 왼, 위
    
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        
        // 사과 위치 (1행, 1열) 시작 -> -1 빼주기
        LinkedList<int[]> apple = new LinkedList<>();
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            
            apple.add(new int[]{x, y});
            arr[x][y] = 1;
        }
        
        // 방향 변환 정보
        arr[0][0] = 2;
        snake.add(new int[]{0, 0}); // 시작: {0, 0}
        d = 0; // 뱀 머리 뱡항: 오른쪽

        boolean stop = false;
        l = Integer.parseInt(br.readLine());
        for (int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            
            // System.out.println("----------------");
            // System.out.println("sec: " + sec + " dir: " + dir);
            
            // 뱀 이동
            stop = search(sec);
            
            // System.out.println("stop: " + stop);
            
            if (stop) break; // 게임 종료
            
            // 방향 회전
            spin(dir);
        }
        
        if (!stop) {
            search(10000);
        }
        
        System.out.println(answer);
        br.close();
    }
    
    public static boolean search(int sec) {
        while (answer < sec) {
            answer++;
            
            // 머리
            int[] cSnake = snake.getFirst();
            int cx = cSnake[0] + pos[d][0];
            int cy = cSnake[1] + pos[d][1];
            
            if (cx < 0 || cx >= n || cy < 0 || cy >= n) return true; // 벽 > 종료
            if (arr[cx][cy] == 2) return true; // 자기 몸 > 종료
            
            if (arr[cx][cy] == 1) {
                // 머리 이동
                arr[cx][cy] = 2;
                snake.addFirst(new int[]{cx, cy});
            } else {
                // 사과 X(빈칸 or 자신) > 몸통 줄이기
                int[] lSnake = snake.removeLast();
                arr[lSnake[0]][lSnake[1]] = 0; 
                
                // 머리 이동
                arr[cx][cy] = 2;
                snake.addFirst(new int[]{cx, cy});
            }
        }
        
//         for (int i=0; i<n; i++) {
//             System.out.println(Arrays.toString(arr[i]));
//         }
        
        return false;
    }

    
    // 뱀 방향 회전
    public static void spin(char dir) {
        // System.out.println("spin -- sec: " + answer + " dir: " + dir);
        if (dir == 'L') { // 왼
            d = d > 0? d-1: 3;
        } else { // 오른
            d = (d + 1)%4;
        }
    }
}
