import java.io.*;
import java.util.*;

/*
풀이 1
1, 집합 U에서 세 수 선택
2. 세 수의 합 d가 U 안에 포함되는 경우 중, 가장 큰 d
- 세 수를 각각 구하면 O(n^3) 으로 46%에서 시간초과가 발생

정답 풀이2
- x + y + z = k -> x + y = k - z
1. 가능한 모든 x + y 에 대한 집합을 생성 O(n^2)
2. k - z 가 해당 집합에 존재하는지 확인 O(n^2)
*/
public class Main {
    static int n;
    static long[] arr;
    static long[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        sum = new long[n*n];
        
        for (int i=0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        // 1. 모든 x + y 집합 구하기
        int idx = 0;
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                sum[idx++] = arr[i] + arr[j];
            }
        }
        
        Arrays.sort(arr);
        Arrays.sort(sum);
        
        // 2. k - z 존재 여부 확인
        for (int k=n-1; k >= 0 ; k--) {
            for (int z=0; z < k; z++) {
                long target = arr[k] - arr[z];
                
                if (find(target)) {
                    System.out.println(arr[k]);
                    return;
                } 
            }
        }
        
    }
    
    public static boolean find(long num) { 
        int start = 0;
        int end = sum.length-1;
        
        while (start < end) {
            int mid = (start + end)/2;
            
            if (num == sum[mid]) {
                return true;
            } else if (num > sum[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
                    
        return false;
    }
}