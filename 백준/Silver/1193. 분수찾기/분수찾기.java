import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        
        int cnt = -1;     
        int start = 0;
        int end = 0;
        while (true) {
            cnt++;
            start = end + 1;
            end = start + cnt;
            if (x < start || x > end) continue;

            int step = x - start;
            int a;
            int b;
            if (cnt%2 == 0) {
                a = cnt +1;
                b = 1; 
                System.out.println((a - step) + "/" + (b + step));
            } else {
                a = 1;
                b = cnt +1;
                System.out.println((a + step) + "/" + (b - step));
            }
            
            break;
        }    
    }
}