import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] numlist;
    static int[] D;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numlist = new int[n];
        
        numlist = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 초기값 정의
        D = new int[n];
        D[0] = numlist[0];
        
        // 현재 i 번째 수를 포함하는 원소의 합이 최대인 부분 수열 구하기
        for (int i=1; i < n; i++) {
            int before = 0; // 앞에 있는 원소들을 포함하는 부분 수열 중 최대
            
            // 앞에 있는 원소 중 현재 수보다 작은 값 j 찾기
            // 해당 수를 포함하는 부분 수열 중 원소의 합이 제일 큰 j 선택
            for (int j=i-1; j >= 0; j--) {
                if (numlist[i] > numlist[j] && D[j] > before) {
                    before = D[j];
                }
            }
            
            D[i] = before + numlist[i];
        }
        
        int max = D[0];
        for (int i=1; i < n; i++) {
            max = Math.max(max, D[i]);
        }   
        System.out.println(max);
        br.close();
	}  
    
}