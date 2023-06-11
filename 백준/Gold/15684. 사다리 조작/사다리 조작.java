import java.util.*;
import java.io.*;

/*
접근법
- 0 부터 ~ 3 개 까지 사다리를 놓고 확인 > 백트래킹
- 모든 i 번째 사다리가 i 결과를 가지면 > 해당 cnt 출력

조건
- 가로선이 연속할 수 없다.
*/
public class Main {
    static int n, m, h; // 세로선, 가로선, 세로선에서 가능한 위치
    static int[][] line;
    static int min = -1;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        
        // 존재하는 가로선 정보
        // b 와 b+1 을 잇는 가로선이 a 에 위치
        line = new int[n+1][h+1];
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            line[b][a] = 1;
        }
        
        // 0, 1, 2, 3 개까지 사다리를 놓을 수 있다.
        for (int i=0; i <= 3; i++) {
            search(0, i);
            if (min >= 0) {
                break;
            }
        }
        
        System.out.println(min);
    }
    
    public static void search(int k, int cnt) {
        if (k == cnt) {
            if (check()) {
                min = k;
            }
            return;
        }
        
        // 마지막 사다리엔 가로선을 놓을 수 없으니 제외
        for (int i=1; i < n; i++) {
            for (int j=1; j <= h; j++) {
                if (line[i][j] == 1) continue;
                if (line[i-1][j] == 1) continue;
                if (line[i+1][j] == 1) continue;
                
                line[i][j] = 1;
                search(k+1, cnt);
                line[i][j] = 0;
            }
        }
    }
    
    /*
    사다리 타기 결과 확인
    - 오른쪽 방향, 왼쪽 방향에 사다리가 존재하는지 확인 > 가로 이동
    - 사다리 없으면 > 아래로 이동
    - i 번째 사다리 결과가 i 가 아닐 경우 > 확인 종료
    
    
    - curLine : 현재 사다리
    - start : 현재 가로선 위치
    */
    public static boolean check() {
        for (int i=1; i <= n; i++) {
            int curLine = i;
            int start = 1;
            
            while (start <= h) {
                if (line[curLine][start] == 1) {
                    curLine++;
                    start++;
                } else if (line[curLine-1][start] == 1) {
                    curLine--;
                    start++;
                } else {
                    start++;
                }
            }
            
            if (i != curLine) return false;
        }
        return true;
    }
 
}
