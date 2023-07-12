import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 이항계수
        // n! / (n-k)! * k!;
        // = n * (n-1) * ... * (n-k+1) / (n-k)!
        if (n < k) {
            System.out.println(0);
            return;
        }

        int result = 1;
        
        for (int i=1; i <= n; i++) {
            result *= i;
        }
        
        for (int i=1; i <= n-k; i++) {
            result /= i;
        }
        
        for (int i=1; i <= k; i++) {
            result /= i;
        }
        
        System.out.println(result);
        
    }
}