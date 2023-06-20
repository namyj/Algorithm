import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] cost; // 각 집의 {R, G, B} 비용 
    static int[][] D;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        cost = new int[n][3];
        D = new int[n][3];
        for (int i=0; i < n ; i++) {
            cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        
        // 초기값
        D[0][0] = cost[0][0];
        D[0][1] = cost[0][1];
        D[0][2] = cost[0][2];
        
        for (int i=1; i < n; i++) {
            D[i][0] = cost[i][0] + Math.min(D[i-1][1], D[i-1][2]);
            D[i][1] = cost[i][1] + Math.min(D[i-1][0], D[i-1][2]);
            D[i][2] = cost[i][2] + Math.min(D[i-1][0], D[i-1][1]);
        }
        
        int result = Math.min(D[n-1][0], D[n-1][1]);
        result = Math.min(result, D[n-1][2]);
        System.out.println(result);
	}  
}