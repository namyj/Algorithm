import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] numlist;
    static int[][] D;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        numlist = new int[501][501];
        
        for (int i=1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j <= i; j++) {
                numlist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 초기값 정의
        D = new int[501][501];
        D[1][1] = numlist[1][1];
        
        for (int i=2; i <= n; i++) {
            for (int j=1; j <= i; j++) { // i 층의 원소 개수 = i 개
                D[i][j] = numlist[i][j] + Math.max(D[i-1][j], D[i-1][j-1]);
            }
        }
        
        // n 층에서 최대값 찾기
        int result = 0;
        for (int i=1; i <= n; i++) {
            result = Math.max(result, D[n][i]);
        }
        
        bw.write(result + "");
        
        bw.flush();
        bw.close();
        br.close();
	}  
    
}