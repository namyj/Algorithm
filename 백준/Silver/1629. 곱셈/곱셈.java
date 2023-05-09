// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;

public class Main {
     public static long mod(int a, int b, int c) {
        if (b == 1) return a % c; //  base condition
        
         // a%c = a 인 경우 존재 > val을 long 으로 선언
        long val = mod(a, b/2, c);
        val = (val * val) % c;

        if (b%2 == 0) return val;
        return val * a % c;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken());
        
        System.out.println(mod(a, b, c));
    }
}