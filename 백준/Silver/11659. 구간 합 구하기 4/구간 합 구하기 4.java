import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] numlist;
    static int[] D;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numlist = new int[n];
        numlist = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        D = new int[n+1];
        
        // 초기값
        D[0] = numlist[0];
        
        for (int i=1; i < n; i++) {
            D[i] = numlist[i] + D[i-1];
        }
        
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            if (start == 1) {
                System.out.println(D[end-1]);
            } else {
                System.out.println(D[end-1] - D[start-2]);
            }
        }
        
	}  
}