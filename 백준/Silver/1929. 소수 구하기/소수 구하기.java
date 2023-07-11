import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        int result = 0;
        for (int i=m; i <= n; i++) {
            if (isPrime(i)) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        
        for (int i=2; i*i <= num ; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}