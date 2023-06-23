import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[][] D; // 90 을 넣으면 int 범위를 벖어남
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        // 초기값 정의
        D = new long[n+1][2];
        D[1][0] = 0;
        D[1][1] = 1;
        
        if (n > 1) {
            D[2][0] = 1;
            D[2][1] = 0;
        }
        
        for (int i=3; i <= n; i++) {
            D[i][0] = D[i-1][0] + D[i-1][1];
            D[i][1] = D[i-1][0];
        }
        
        System.out.println(D[n][0] + D[n][1]);
        
        br.close();
	}  
    
}