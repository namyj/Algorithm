import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static Integer[] coin; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 동전 종류
        k = Integer.parseInt(st.nextToken()); // 가치의 합
        coin = new Integer[n];

        for (int i=0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(coin, Comparator.reverseOrder());
        
        int result = 0;
        int sum = 0;
        int idx = 0;
        while (k > 0) {
            if ( k - coin[idx] >= 0 ) {
                int tmp = k / coin[idx];
                result += tmp;
                k -= coin[idx]*tmp;
            } else {
                idx++;
            }
        }
        
        System.out.println(result);

    }
}