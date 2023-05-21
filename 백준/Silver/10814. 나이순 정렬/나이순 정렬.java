// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;

// 나이 오름차순 -> 먼저 가입한 순
// statble sort -> merger sort

/*
- 나이&이름 순서 저장
- 이름 저장 문자열 배열

merge sort로 나이 순서 정렬
최종적으로 나이를 출력하면서 순서에 해당하는 이름 출력
*/
public class Main {
    static int n;
    static int[][] arr;
    static String[] names;
    
    public static void mergeSort(int l, int r) {
        if (l == r) return;
        
        int mid = (l+r)/2;
        mergeSort(l, mid);
        mergeSort(mid+1, r);
        merge(l, mid, r);
    }
    
    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = 0;
        int[][] sorted = new int[right - left + 1][];
        
        while (l <= mid && r <= right) {
            if (arr[l][0] <= arr[r][0]) {
                sorted[idx++] = arr[l++].clone();
            } else {
                sorted[idx++] = arr[r++].clone();
            }
        }
        
        while (l <= mid) {
            sorted[idx++] = arr[l++].clone();
        }
        while (r <= right) {
            sorted[idx++] = arr[r++].clone();
        }
        
        for (int i=left; i <= right  ; i++) {
            arr[i] = sorted[i-left].clone(); 
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][];
        names = new String[n];
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), i};
            names[i] = st.nextToken();
        }
        
        mergeSort(0, n-1);
        
        for (int i=0; i < n; i++) {
            bw.write(arr[i][0] + " " + names[arr[i][1]] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();

    }
}