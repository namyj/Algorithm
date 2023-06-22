import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static int[][] D;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        
        D = new int[41][2];
        
        // 초기값 정의
        D[0] = new int[] {1, 0};
        D[1] = new int[] {0, 1};
        
        for (int j = 2; j <= 40; j++) {
            D[j][0] = D[j-1][0] + D[j-2][0];
            D[j][1] = D[j-1][1] + D[j-2][1];
        }
        
        for (int i=0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            
            bw.write(D[n][0] + " " + D[n][1] + "\n");            
        }
        
        bw.flush();
        bw.close();
        br.close();
	}  
}