import java.io.*;
import java.util.*;

/*
배열 내 중복 원소 제거
- Arrays > HashSet 변환 > 다시 Array 변환
*/
public class Main {
    static int n;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        
        for (int i=0; i < n; i++) {
            arr[i] = br.readLine();
        }
        
        // 중복제거
        HashSet<String> hSet = new HashSet<>(Arrays.asList(arr));
        arr = hSet.toArray(new String[0]);
        
        // 정렬 조건 : 길이 > 사전 순
        // 따라서 사전순 정렬 > 길이 정렬하면서 길이가 동일할 경우 사전순을 유지한 결과로 정렬된다. 
        Arrays.sort(arr);
        Arrays.sort(arr, (o1, o2) -> {
            return o1.length() - o2.length(); 
        });
        
        for (int i=0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

}
