// "static void main" must be defined in a public class.

import java.util.*;
import java.io.*;

/**
 * merge sort
 */
public class Main {  
    static int[] arr;
    static int[] arrA;
    static int[] arrB;
    
    public static void merge(int left, int right) {
        int l = 0;
        int r = 0;
        int idx = 0;
        
        while (l < left && r < right) {
            if (arrA[l] <= arrB[r]) {
                arr[idx++] = arrA[l++];
            } else {
                arr[idx++] = arrB[r++];    
            }
        }
        
        // 남은 원소 > 최종 배열에 넣기
        while (l < left) {            
            arr[idx++] = arrA[l++];
        }
        while (r < right) {
            arr[idx++] = arrB[r++];
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+m]; // 결과
        
        arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        merge(n, m);
        
        for (int i=0; i < n+m; i++) {
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}