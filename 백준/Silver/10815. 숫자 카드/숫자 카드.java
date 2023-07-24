import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arrN;
    static int[] arrM;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        arrN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        m = Integer.parseInt(br.readLine());
        arrM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(arrN);
        
        for (int i=0; i < m; i++) {
            if (find(arrM[i])) {
                bw.write(1 + " ");
            } else {
                bw.write(0 + " ");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 이분 탐색 O(logN)
    static boolean find(int num) {
        int start = 0;
        int end = n-1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (num == arrN[mid]) {
                return true;
            } else if (num > arrN[mid]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }
}