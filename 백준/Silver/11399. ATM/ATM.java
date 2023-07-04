import java.io.*;
import java.util.*;

// 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
public class Main {
    static int n;
    static int[] arr; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(arr);
        
        int result = 0;
        int before = 0;
        for (int i=0; i < n; i++) {
            before += arr[i];
            result += before;
        }
        
        System.out.println(result);

    }
}