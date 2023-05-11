// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[] arr = new int[10];
    
    static BufferedReader br;
    static BufferedWriter bw;
    
    public static void func(int k) throws IOException {
        if (k == m) {
            for (int i=0; i < m ; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        // 중복된 숫자 선택 가능
        for (int i=1; i <= n; i++) {
            arr[k] = i;
            func(k+1);
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        func(0);
        
        bw.flush();
        bw.close();
        br.close();
        
        
    }
}