import java.io.*;
import java.util.*;

/*
1. 연산자 조합 생성
2. 계산

- 연산 결과값의 범위가 int 안
*/
public class Main {
    static int n;
    static int[] arr; // 수열
    static char[] operators = {'+', '-', '*', '/'};
    static char[] list;
    static boolean[] visited;
    static char[] output;
    
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 순열 입력
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 연산자 입력
        int idx = 0;
        list = new char[n-1];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < 4; i++) {    
            int tmp = Integer.parseInt(st.nextToken());
            
            for (int j=0; j < tmp ; j++) {
                list[idx++] = operators[i];
            }
        }
        
        output = new char[n-1];
        visited = new boolean[n-1];
        
        permutation(0, n-1);
    
        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }
    
    /*
    가능한 순열 구하기 = r 개 수 선택하기
    r 개 수 선택 > calc
    */
    public static void permutation(int depth, int r) {
        if (depth == r) {
            calc();
            return;
        }
        
        for (int i=0; i < n-1; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            output[depth] = list[i];
            permutation(depth + 1, r);
            visited[i] = false;
        }
        
    }
    
    public static void calc() {
        int result = arr[0];
        int idx = 0; // 연산자 인덱스
        
        
        for (int i=1; i < n; i++) {
            switch(output[idx]) {
                case '+':
                    result += arr[i];
                    break;
                case '-':
                    result -= arr[i];
                    break;
                case '*':
                    result *= arr[i];
                    break;
                case '/':
                    result /= arr[i];
                    break;
                default:
                    break;
            }
            idx++;
        }
        
        max = Math.max(result, max);
        min = Math.min(result, min);
    }
    
}
