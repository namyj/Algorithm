import java.io.*;
import java.util.*;

/*
N개의 정수 중 두 수의 차이가 M 이상이며 제일 작은 경우
*/

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
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i < n; i++) {
            int left = i+1;
            int right = n-1;
            
            while (left <= right) {
                int mid = (left+right)/2;
                int sub = Math.abs(arr[i] - arr[mid]);
                
                if (sub >= m && min > sub) 
                    min = sub;
                
                if (sub >= m) {
                    // 차이가 크다 > 더 작은 수 탐색
                    right = mid-1;
                } else {
                    // 차이가 작다 > 더 큰 수를 탐색
                    left = mid+1;
                }
            }
        }
        System.out.println(min);
    }
}