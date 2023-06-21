import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int result;
    static int[][] D; // 횟수, 선택한 연산의 결과값
    static ArrayList<Integer> numlist;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        D = new int[n+1][2]; 
        
        result = 0;
        numlist = new ArrayList<>();
        
        // 초기값 정의
        D[1] = new int[]{0, 1};
        if (n > 1)  {
            D[2] = new int[]{1, 1};
        }
        
        for (int i=3; i <= n; i++) {
            D[i][0] = D[i-1][0] + 1;
            D[i][1] = i - 1;
            
            if (i%3 == 0 && D[i][0] > D[i/3][0] + 1) {
                D[i][0] = D[i/3][0] + 1;
                D[i][1] = i/3;
            }
            
            if (i%2 == 0 && D[i][0] > D[i/2][0] + 1) {
                D[i][0] = D[i/2][0] + 1;
                D[i][1] = i/2;
            }
        }
        
        bw.write(D[n][0] + "\n");
        for (int i=n; i > 1;) {
            bw.write(i + " ");
            i = D[i][1];
        }
        bw.write("1");
        
        bw.flush();
        bw.close();
        br.close();
	}  
}