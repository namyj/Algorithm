import java.io.*;
import java.util.*;

// 이항계수 - 파스칼의 삼각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1 <= N <= 1000 으로 int 범위를 벗어난다.
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
    
        int[][] D = new int[1001][1001];
        
        for (int i=0; i <= n; i++) {
            for (int j=0; j <= i; j++) {
                if (i==j || j == 0)
                    D[i][j] = 1;
                else
                    D[i][j] = (D[i-1][j-1] + D[i-1][j]) % 10007;
            }
        }
        
        System.out.println(D[n][k] % 10007);
        
    }
}