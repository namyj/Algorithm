import java.io.*;

/*
세가지 연산
- 3으로 나누어 떨어짐 > 3 으로 나누기
- 2로 나누어 떨어짐 > 2 로 나누기
- 1 빼기

그냥 재귀로 구현하면 시간초과 > 중복되는 연산이 너무 많음
> 중간 결과를 저장 & 사용
*/
public class Main {
    static int result = Integer.MAX_VALUE;
    static int x;
    static int[] D;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        D = new int[x+1];
        
        // 초기값
        // D[1] = 0;
        
        for (int i=2; i <= x ; i++) {
            D[i] = D[i-1] + 1; // case1: 1 빼기
            if (i%2 == 0) D[i] = Math.min(D[i/2] + 1, D[i]);
            if (i%3 == 0) D[i] = Math.min(D[i/3] + 1, D[i]);
        }

        System.out.println(D[x]);
		
	}  
}