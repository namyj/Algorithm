import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] D;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        // 초기값 정의
        D = new int[1001];
        D[1] = 1;
        D[2] = 3;
        
        for (int i=3; i <= n; i++) {
            D[i] = (D[i-1] + D[i-2]*2) % 10007;
        }
        
        System.out.println(D[n]);
        
        br.close();
	}  
    
}