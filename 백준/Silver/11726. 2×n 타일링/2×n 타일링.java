import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] D;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        D = new int[n+1];
        
        if (n == 1) {
            System.out.println(1);
            return;
        }
        
        // 초기값
        D[1] = 1;
        D[2] = 2;
        
        for (int i=3; i <= n; i++) {
            D[i] = (D[i-1] + D[i-2])%10007;
        }
        
        System.out.println(D[n]);
	}  
}