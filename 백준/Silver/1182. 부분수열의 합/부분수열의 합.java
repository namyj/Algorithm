import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int s;
    public static int result = 0;
    public static int[] arr;
    public static boolean[] isUsed;
    public static void func() {
        for (int i=0; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                sum(arr[i], i+1);
                isUsed[i] = false;
            }
        }   
    }
    
    public static void sum(int k, int start) {
        if (k == s) {
            result++;
        } 
        
        for (int i=start; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                sum(k + arr[i], i+1);
                isUsed[i] = false;
            }
        }   
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        isUsed = new boolean[n];
            
        func();
        
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}