import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static long[] D; // 100을 넣었을 때 integer 범위를 벗어남!!
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        
        D = new long[101];
        
        // 초기값 정의
        D[1] = 1L;
        D[2] = 1L;
        D[3] = 1L;
        D[4] = 2L;
        
        for (int i=5; i <= 100; i++) {
            D[i] = D[i-1] + D[i-5];
        }
        
        for (int i=0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(D[n]);
        }
        
        br.close();
	}  
    
}