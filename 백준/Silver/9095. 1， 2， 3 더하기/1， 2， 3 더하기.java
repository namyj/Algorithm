import java.io.*;

public class Main {
    static int t;
    static int[] D = new int[11];
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        
        // 초기값
        D[0] = 1;
        
        for (int i=0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            func(n);
        }
	}  
    
    public static void func(int x) {
        for (int i=1; i <= x ; i++) {
            D[i] = D[i-1];
            if (i-2 >= 0) D[i] += D[i-2];
            if (i-3 >= 0) D[i] += D[i-3];
        }

        System.out.println(D[x]);
    }
}