import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        t = Integer.parseInt(br.readLine());
        arr = new int[4];
            
        for (int i=0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            
            
            boolean isPossible = false;
            for (int j=x; j < n*m; j+=m) {
                if (j % n == y) {
                    isPossible = true;
                    bw.write((j+1)+"\n");
                    break;
                }
            }
            
            if (!isPossible) {
                bw.write("-1\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}