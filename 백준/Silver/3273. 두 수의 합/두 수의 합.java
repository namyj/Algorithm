import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 접근법
 * - 이중 for 문, 두 원소끼리 더하기 > 시간 초과
 * - InputStream, ... 등 사용 > 시간 초과
 * - 투 포인터
 */
public class Main {
    

    public static void main(String[] args) throws IOException {
        int result = 0, sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력
        int nVal = Integer.parseInt(br.readLine());
        int[] arr = new int[nVal];
        int left = 0, right = arr.length - 1;

        // 참고) 공백으로 구분된 정수 리스트 입력 방법
        // StringTokenizer로 공백을 구분자로 토큰별 입력 받음 > 한 토큰씩 읽어서 Integer.parseInt()
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nVal; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int xVal = Integer.parseInt(br.readLine());

        // 2. 입력 배열 정렬
        Arrays.sort(arr); // 라이브러리 사용
        
        
        // 3. result 구하기
        while (left < right) {
            if (arr[left] + arr[right] == xVal) { // case1
                result++;
                left++;
                right--;
            } else if (arr[left] + arr[right] > xVal) { // case2
                right--;
            } else { // case3
                left++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

        br.close();
        bw.close();
    }
}