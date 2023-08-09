import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        
        while (start < n && end < n) {
            int sub = arr[end] - arr[start];
            
            if (sub >= m) {
                min = Math.min(min, sub);
                start++;
            } else {
                end++;
            }
        }
        
        System.out.println(min);
    }
    
}