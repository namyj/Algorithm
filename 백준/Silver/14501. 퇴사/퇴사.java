import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int max = 0; // 아무런 상담을 하지 못하는 경우, 최소 0 (Integeer.MIN_VALUE 로 초기화해서 틀린 것)
    static int[][] timetable;
    static int[][] D;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        
        timetable = new int[n+1][2];
        
        for (int i=1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            timetable[i][0] = Integer.parseInt(st.nextToken());
            timetable[i][1] = Integer.parseInt(st.nextToken());
        }
        
        
        // 초기값 정의
        D = new int[n+1][2];
        
        // 1. 해당 일자의 상담을 포함한 최대 수익 찾기
        // 2. max 업데이트
        for (int i = 1; i <= n ; i++) {
            if (timetable[i][0] > n - i + 1) continue; // n 일을 넘는 경우 > pass
            
            D[i][0] = timetable[i][0];
            D[i][1] = timetable[i][1];
            
            int cnt = 0;
            for (int j = i-1; j > 0; j--) {
                cnt++;
                if (D[j][0] - cnt <= 0) {
                    D[i][1]  = Math.max(D[i][1], D[j][1] + timetable[i][1]);
                }
            }
            
            max = Math.max(max, D[i][1]);
        }
        

        System.out.println(max);
        br.close();
	}  
    
}