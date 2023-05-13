// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr; // n개 수
    static int[] result; // 결과
    static boolean[] isUsed; // 방문 여부
    
    static BufferedReader br;
    static BufferedWriter bw;
    
    public static void func(int k) throws IOException {
        if (k == m) {
            for (int i=0; i < m ; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        for (int i=0; i < n; i++) {
            if (!isUsed[i]) {
                result[k] = arr[i];
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
        
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // n개 수
        Arrays.sort(arr); // 오름차순 방문
        isUsed = new boolean[n]; 
        result = new int[m]; 
         
        func(0);
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}