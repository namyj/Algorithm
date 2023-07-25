import java.io.*;
import java.util.*;

/*
- "길이"를 대상으로 이분 탐색
- min = 1, max = arr의 최대 길이로 적합한 mid를 탐색
- mid 길이로 구한 개수 >= m -> 길이를 더 늘릴 수 있다.
- mid 길이로 구한 개수 < m -> 길이를 줄여야 한다. 

min = 1 로 설정한 이유? 길이는 양의 정수이기 때문
*/
public class Main {
    static int n, m;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 조카 수
        n = Integer.parseInt(st.nextToken()); // 과자 수

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(arr);
        
        int min = 1;
        int max = arr[n-1];
        int cnt = 0;
        
        while (min <= max) {
            int mid = (min + max)/2;
            cnt = 0;
            
            for (int i=n-1; i >= 0; i--) {
                if (arr[i] < mid) break;
                
                cnt += (arr[i]/mid);
            }
            
            // 길이를 늘릴 수 있음
            if (cnt >= m) {
                min = mid+1;
            } else { // 길이를 줄여야 한다.
                max = mid-1;
            }
        }
        
        if (cnt == 0)
            System.out.println(0);
        else
            System.out.println(max);

        br.close();
    }
    
}