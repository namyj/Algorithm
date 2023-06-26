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
        D = new int[n];
        
        numlist = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 초기값 정의
        D[0] = numlist[0];
        int max = numlist[0];
        
        for (int i=1; i < n; i++) {
            // 이전 D 값 + 현재 num 값 , 현재 num 값 중 큰 것을 D에 저장
            D[i] = Math.max(D[i-1] + numlist[i], numlist[i]);
            
            max = Math.max(max, D[i]);
        }
        
        System.out.println(max);
        br.close();
	}  
    
}