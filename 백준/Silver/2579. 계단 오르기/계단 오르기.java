import java.io.*;

public class Main {
    static int n;
    static int[] score;
    static int[][] D;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        score = new int[n+1];
        D = new int[n+1][3];
        
        // 초기값
        for (int i=1; i <= n ; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }
        
        // 초기값
        D[1][1] = score[1];
        D[1][2] = 0;
        D[2][1] = score[2];
        D[2][2] = score[1] + score[2];
        
        for (int i=3; i <= n; i++) {
            D[i][1] = score[i] + Math.max(D[i-2][1], D[i-2][2]);
            D[i][2] = score[i] + D[i-1][1];
        }
        
        System.out.println(Math.max(D[n][1], D[n][2]));
	}  
}