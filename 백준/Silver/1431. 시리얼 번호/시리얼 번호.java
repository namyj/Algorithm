// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;

/*
정렬 조건
- 길이가 짧은 것
- 자리수 숫자의 합이 작은 것 (숫자만)
- 사전 순 (숫자 > 알파벳)
*/
public class Main {
    static int n;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        
        for (int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }
        
        // 1. 길이 순 정렬
        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
        Arrays.sort(arr);
        
        Arrays.sort(arr, (s1, s2) -> 
            s1.length() == s2.length() ? sumString(s1) - sumString(s2) : s1.length() - s2.length());
       
        for (int i=0; i<n ; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int sumString(String s) {
        int sum = 0;
        for (int i=0; i< s.length(); i++) {
            int tmp = (int) s.charAt(i); 
            if (tmp >= 48 && tmp <= 57) {
                sum += (tmp - 48);
            }
        }
        return sum;
    }
}