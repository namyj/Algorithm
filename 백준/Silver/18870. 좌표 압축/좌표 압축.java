import java.io.*;
import java.util.*;

/*
수직선 위에 N 개 좌표 존재
좌표 X_i 압축
- (수직선 위에 존재하는 좌표 중) X_i 보다 작은 서로다른 좌표의 개수

1. 정렬
2. 해당 수의 under bound 찾기 - 이분 탐색
*/
public class Main {
    static int n;
    static int[] arr;
    static Integer[] keys;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        keys = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(keys);
        
//         System.out.println(Arrays.toString(arr));
//         System.out.println(Arrays.toString(keys));
        
        for (int i=0; i < n; i++) {
            bw.write(find(arr[i], 0, keys.length) + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int find(int num, int start, int end) {
        int mid;
        
        while (start < end) {
            mid = (start + end)/2;
            
            if (num == keys[mid]) {
                return mid;
            } else if (num > keys[mid]) {
                start = mid + 1; 
            } else {
                end = mid;
            }
        }
        
        return 0;
    }
}