// "static void main" must be defined in a public class.

import java.util.*;
import java.io.*;

/*
* Merge sort
*/
public class Main {  
    static int n;
    static int[] arr;
    public static void mergeSort(int l, int r) {
        if (l >= r) return; 
            
        int mid = (l+r)/2;
        mergeSort(l, mid);
        mergeSort(mid+1, r);
        merge(l, mid, r); 
    }
    
    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = 0;
        
        int[] sorted = new int[right - left + 1];
        
        // 두 배열의 최소값 비교 > 최종 배열에 넣기
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[idx++] = arr[l++];
            } else {
                sorted[idx++] = arr[r++];    
            }
        }
        
        // 남은 원소 > 최종 배열에 넣기
        while (l <= mid) {            
            sorted[idx++] = arr[l++];
        }
        while (r <= right) {
            sorted[idx++] = arr[r++];
        }
        
        for (int i=left; i <= right; i++) {
            arr[i] = sorted[i-left];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        mergeSort(0, n-1);
        
        for (int i=0; i < n; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}