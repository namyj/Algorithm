// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];
    
    static BufferedReader br;
    static BufferedWriter bw;
    
    public static void func(int k) throws IOException {
        // m개 숫자를 모두 결정 > 출력
        if (k == m) {
            for (int i=0; i < m ; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        // k 번째 숫자 결정 > k+1 번째 숫자 결정하기
        for (int i=1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);
                isUsed[i] = false;
            }
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