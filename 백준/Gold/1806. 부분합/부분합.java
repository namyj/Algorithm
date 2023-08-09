import java.io.*;
import java.util.*;

/*
N개 수열의 연속된 수의 부분 합중 S 이상이고, 가장 짧은 것의 길이
- 투 포인터
1. 시작 left, 끝 right를 설정
2. Sum이 s 미만이면, right를 +1 (구간을 늘린다)
3. sum이 s 이상이면, left를 +1 (구간을 줄인다)

- 시간초과
*/

public class Main {
    static int n, s;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int start = 0;
        int end = 0; // 다음 구간을 가르킴
        int min = Integer.MAX_VALUE;
        int sum = arr[0];
        
        while (start < n && end < n) {
            
            if (sum >= s) {
                min = Math.min(min, end - start+1);
                sum -= arr[start];
                start++;
            } else {
                end++;
                if (end >= n) break;
                
                sum += arr[end];
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);    
        }
    }
}