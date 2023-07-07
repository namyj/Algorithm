import java.io.*;
import java.util.*;

/*
- 3/1 ~ 11/30 매일 한 가지 이상 꽃 피우기  
- 선택한 꽃의 최소 개수

- 종료일이 12/1 까지 꽃 선택
*/
public class Main {
    static int n;
    static int[][] arr; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());
            
            int start = startM * 100 + startD;
            int end = endM * 100 + endD;
            arr[i] = new int[] {start, end};
        }
        
        // 시작 빠른 순 > 끝이 느린 순 
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] != o2[0]? o1[0] - o2[0] : o2[1] - o1[1];
        });
        
        int cur_t = 301; // 현재 시간
        int result = 0;
        int idx = 0;
        
        while (cur_t < 1201) {
            int next_t = cur_t; // 다음 꽃의 지는 시간을 저장할 변수
            
            // 1. 현재 꽃 다음에 필 꽃 중에서 늦게 지는 꽃 찾기
            for (int i=idx; i < n; i++) {
                if (arr[i][0] <= cur_t && arr[i][1] > next_t ) {
                    next_t = arr[i][1];
                    idx = i+1;
                }
                    
            }
            
            // 2. 다음에 필 꽃이 있으면, 해당 꽃으로 cur 값 업데이트
            if (next_t != cur_t) {
                // System.out.println(Arrays.toString(arr[idx-1]));
                result++;
                cur_t = next_t;
            } else {
                result = 0;
                break;
            }
            
        }
        System.out.println(result);

    }
}