// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] result;
    static boolean[] isUsed;
    
    static BufferedReader br;
    static BufferedWriter bw;
    
    
    // arr에 중복되는 숫자 존재  
    public static void func(int k) throws IOException {
        if (k == m) {
            for (int i=0; i < m ; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
              
        for (int i=0; i < n; i++) {
            if (!isUsed[i] && result[k] != arr[i]) {
                result[k] = arr[i];
                isUsed[i] = true;
                func(k+1);
                isUsed[i] = false;
            }
        }
        result[k] = 0;
    }
    
    
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        isUsed = new boolean[n];
        result = new int[m];
         
        func(0);
        
        bw.flush();
        bw.close();
        br.close();

    }
}