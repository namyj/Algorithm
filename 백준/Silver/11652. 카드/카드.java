import java.io.*;
import java.util.*;

/*
가장 많이 가지고 있는 정수 출력
- 입력수 범위: -2^62 <= num <= 2^62

1. 입력 배열 정렬 
2. 배열을 탐색, 직전 수와 비교 > 동일하면 cnt 증가
3. 다른 수를 만나면, 현재 cnt를 최대 개수와 비교 > 더 클 경우 max, result를 업데이트

*/
public class Main {
    static int n;
    static long[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        
        for (int i=0; i<n; i++) {
            arr[i] = Long.parseLong(br.readLine());   
        }
        
        Arrays.sort(arr);
 
        long before = arr[0]; // 직전 수
        int cnt = 1;
        
        // 초기: 가장 맨 처음 값
        long result = arr[0];
        int max = 1;
        
        for (int i=1; i<n ; i++) {            
            if (arr[i] == before) {
                cnt++;
            } else {
                if (max < cnt) {
                    max = cnt;
                    result = before;
                }
                
                cnt = 1;
                before = arr[i];
            }
        }
        // 마지막까지 동일한 숫자가 나온 경우, 한번 더 체크
        if (max < cnt) {
            result = before;
        }
        
        bw.write(result + "");
        bw.close();
        br.close();
    }
}