import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Long[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new Long[n];
        
        
        for (int i=0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int idx = -1;
        for (int i=n-1; i >= 0; i--) {
            if (arr[i] <= 0) {
                idx = i;
                break;
            }
        }
        
        long result = 0;
        long before = 0;
        boolean isZero = false;
        
        // 양수
        for (int i=n-1; i > idx; i--) {
            if (arr[i] == 1) {
                result += arr[i];
            } else if (arr[i] > 0) {
                if (before > 0) {
                    result += (before * arr[i]);
                    before = 0;
                } else {
                    before = arr[i];
                }
            }
        }
        
        result += before;
        before = 0;
        
        // 음수
        for (int i=0; i <= idx; i++) {
            if (arr[i] == 0) {
                isZero = true;
            } else if (arr[i] < 0) {
                if (before < 0) {
                    result += (before * arr[i]);
                    before = 0;
                } else {
                    before = arr[i];
                }
            }    
        }
        
        if (before < 0 && !isZero) {
            result += before;
        }
        
        System.out.println(result);

    }
}