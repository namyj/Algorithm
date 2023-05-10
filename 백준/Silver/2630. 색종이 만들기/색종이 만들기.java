
import java.io.*;
import java.util.*;

public class Main {
    public static int[] cnt = {0,0}; // {흰색 종이 수, 파란색 종이 수}
    public static int[][] arr;
    
    public static boolean check(int x, int y, int n) {
        int before = arr[x][y];
        
        for (int i=x; i < x+n; i++) {
            for (int j=y; j < y+n; j++) {
                if (before != arr[i][j]) return false;
            }
        }
        
        return true;
    }
    
    // x, y: 시작점 n: 가로 길이
    public static void divide(int x, int y, int n) {
        if (n==1) {
            cnt[arr[x][y]]++;
            return;
        }
        
        // 모든 원소의 동일 여부 체크
        if (check(x, y, n)) {
            cnt[arr[x][y]]++;
            return;
        }
        
        // 분할        
        int mid = n/2;
        divide(x, y, mid);
        divide(x, y+mid, mid);
        divide(x+mid, y, mid);
        divide(x+mid, y+mid, mid);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        // 0: 하얀색 1: 파란색
        for (int i=0 ; i<n ;i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();            
        }
        
        divide(0, 0, n);
        
        bw.write(cnt[0]+"\n"+cnt[1]);
        bw.flush();
        br.close();
        bw.close();
        
    
    }
}