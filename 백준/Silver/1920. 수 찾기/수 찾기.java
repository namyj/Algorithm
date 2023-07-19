import java.io.*;
import java.util.*;

/*
수 배열 A에 x가 존재하는지
*/
public class Main {
    static int n;
    static int m;
    static int[] A;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);
        
        m = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for (int i=0; i < m; i++) {
            if(find(arr[i], 0, n-1))
                System.out.println(1);
            else 
                System.out.println(0);
        }
    }
    
    public static boolean find(int num, int start, int end) {
        int mid; 
        while (start <= end) {
            mid = (start + end)/2;
            
            if (A[mid] == num) return true;
            else if (A[mid] > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return false;
    }
    
}