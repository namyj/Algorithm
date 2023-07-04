import java.io.*;
import java.util.*;

// A 배열의 수를 재 배치해서 얻을 수 있는 S의 최솟값
// A 의 최소 값 * B의 최대 값
public class Main {
    static int n;
    static int[] arrA; 
    static int[] arrB; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        arrB = new int[n];

        arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int result = 0;
        for (int i=0; i < n; i++) {
            result += arrA[i] * arrB[n-1-i];
        }
        
        System.out.println(result);

    }
}