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
        D[0] = 1; 
        
        // Prob11055 번 풀이를 길이로 수정
        for (int i=1; i < n; i++) {
            int before = 0;
            
            for (int j=i-1; j >= 0; j--) {
                if (numlist[i] > numlist[j] && D[j] > before) {
                    before = D[j];
                }
            }
            
            D[i] = before + 1;
        }
        
        int max = D[0];
        for (int i=1; i < n; i++) {
            max = Math.max(max, D[i]);
        }   
        System.out.println(max);
        br.close();
	}  
    
}