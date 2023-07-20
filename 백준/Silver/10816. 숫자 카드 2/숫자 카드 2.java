import java.io.*;
import java.util.*;

/*
수 배열에 X 가 몇개 존재하는지
*/
public class Main {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Set<Integer> cSet = new HashSet<Integer>();
        Map<Integer, Integer> cards = new HashMap<Integer, Integer>();
        
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            
            if (cards.containsKey(tmp)) {
                cards.put(tmp, cards.get(tmp) + 1);
            } else {
                cards.put(tmp, 1);
            }
        }
        
        m = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for (int i=0; i < m; i++) {
            if(cards.containsKey(arr[i]))
                bw.write(cards.get(arr[i]) + " ");
            else 
                bw.write(0  + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}