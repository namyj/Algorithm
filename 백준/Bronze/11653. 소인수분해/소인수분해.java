import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        
        if (n == 1) 
            return;
        
        for (int i=2; i<= n; i++) {
            if (n % i == 0 && isPrime(i)) {
                while (n % i == 0) {
                    n /= i;
                    bw.write(i + "\n");
                }
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