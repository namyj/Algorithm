import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[][] D; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        D = new long[n+1][10]; // n개 자리수에 대한 0 ~ 9 기록
        
        // 초기값 정의
        // D[1] = 1 ~ 9 가능
        for (int i=1; i <= 9; i++) {
            D[1][i] = 1L;
        }
        
        // 현재 i 에 존재하는 0 ~ 9 개수 세기
        // 1. 이전 i-1의 0 ~ 9 개수를 탐색
        // 2. 이전 i-1에서 0, 9 는 1, 8 에만 개수를 더해줌
        // 3. 이전 i-1에서 나머지 수는 해당 수 -1, +1 에 개수를 더해줌
        for (int i=1; i < n; i++) {
            for (int j=0; j <= 9; j++) {
                if (j == 0) {
                    D[i+1][1] += D[i][j] % 1000000000;
                } else if (j == 9) {
                    D[i+1][8] += D[i][j] % 1000000000;
                } else {
                    D[i+1][j-1] += D[i][j] % 1000000000;
                    D[i+1][j+1] += D[i][j] % 1000000000;
                }
            }
        }
        
        long result = 0L;
        for (int i=0; i<=9; i++) {
            result += D[n][i] % 1000000000;
        }
        
        System.out.println(result % 1000000000);

    }
}