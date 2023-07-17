import java.io.*;
import java.util.*;
/*
n=0 -> n! = 1
n=1 -> n! = 1
n=2 -> n! = 2
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int cnt2 = 0;
        int cnt5 = 0;
        
        // 2, 5의 개수 -> 10의 지수 얻기
        // i 가 2 or 5 의 제곱수인 경우, 제곱한 만큼 개수를 세야한다. 
        for (int i=2; i <= n; i++) {
            int tmp = i;

            while (tmp % 10 == 0) {
                cnt2++;
                cnt5++;
                tmp /= 10;
            }
            while (tmp % 2 == 0) {
                cnt2++;
                tmp /= 2;
            }
            while (tmp % 5 == 0) {
                cnt5++;
                tmp /= 5;
            }
        }
        System.out.println(Math.min(cnt2, cnt5));        
    }
}