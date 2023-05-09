// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;

// merge sort 수행 과정에서 배열에 K 번째 저장되는 수를 출력

public class Main {
    public static int n;
    public static int k = 0;
    public static int cnt = 0;
    public static int[] arr;
    
    public static void mergeSort(int left, int right) {
        if (left >= right) return;
        
        int mid = (left + right) / 2; // 배열 중간 지점

        mergeSort(left, mid);
        mergeSort(mid+1, right);
        merge(left, mid, right);
    }
    
    public static void merge(int left, int mid, int right) {
        // System.out.printf("left : %d right: %d mid : %d\n", left, right, mid);
        int l = left; // 왼쪽 부분 리스트 시작점
        int r = mid + 1; // 오른쪽 부분 리스트 시작점
        int idx = 0;
        int[] sorted = new int[right - left + 1];
            
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[idx++] = arr[l++];
            } else {
                sorted[idx++] = arr[r++];
            }
        }
        
        while (l <= mid) {
            sorted[idx++] = arr[l++];
        }
        
        while (r <= right) {
            sorted[idx++] = arr[r++];
        }
        
        for (int i=left; i <= right; i++) {
            arr[i] = sorted[i-left];
            cnt++;
            if (cnt == k) {
                System.out.println(arr[i]);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        mergeSort(0, n-1);
        if (cnt < k){
            System.out.println(-1);
        }
        
    }
}