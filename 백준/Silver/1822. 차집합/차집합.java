import java.io.*;
import java.util.*;

/*
- 집합 A에는 속하고 집합 B에는 속하지 않는 모든 원소 구하기
*/
public class Main {
    static int a, b;
    static int[] arrA;
    static int[] arrB;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        
        int cnt = 0;
        for (int i=0; i < a; i++) {
            if (!find(arrA[i])) {
                cnt++;
                sb.append(arrA[i] + " ");
            }
        }
        
        if (cnt == 0) {
            System.out.println(cnt);
            return;
        } else {
            sb.insert(0, cnt+"\n");
            System.out.println(sb.toString());
        }

        br.close();
    }
    
    static boolean find(int num) {
        int start = 0;
        int end = b-1;
        
        while (start <= end) {
            int mid = (start + end)/2;
            
            if (num == arrB[mid]) {
                return true;
            } else if (num > arrB[mid]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        
        return false;
    }
}