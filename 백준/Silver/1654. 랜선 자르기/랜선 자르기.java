import java.io.*;
import java.util.*;

/*
- K 개 랜선에서 동일한 길이의 N개의 랜선을 만들 수 있는 최대 랜선의 길이
- 이분 탐색의 대상이 "인덱스"가 아닌 "길이"

정답 풀이
- min = 0, max = arr[arr.length-1] + 1로 이분 탐색을 진행
- cnt += (각 랜선의 길이 / mid) 가 N 보다 크거나 같을 때 > 하한 업데이트 (랜선의 최대 길이를 찾아야하기 때문에 바로 출력하지 않고, 게속 탐색) 
- 주의) max를 최대값 + 1로 해준 이유는, 랜선의 길이가 1 일 때 (0 + 1) / 2 = 0으로
    mid = 0 이 된다. 그래서 최대값 + 1 로 진행한다.
*/
public class Main {
    static int n, k;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new long[k];
        
        for (int i=0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(arr);
        
        long min = 0;
        long mid = 0;
        long max = arr[arr.length-1]+1;
        
        while (min < max) {
            mid = (min + max) / 2;
            
            long cnt = 0;
            for (int i=0; i < k; i++) {
                cnt += (arr[i]/mid);
            }
            
            // 개수가 부족 > 자르는 길이를 줄여야 한다.
            if (cnt < n) {
                max = mid;
            } else { // 그 외 > 자르는 길이를 늘려야 한다. 
                min = mid + 1;
            }
        }
        
        System.out.println(min-1);
    }
}