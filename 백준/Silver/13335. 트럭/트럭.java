import java.io.*;
import java.util.*;

public class Main {
    static int n; // 트럭 수
    static int w; // 다리 길이
    static int L; // 최대 하중

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 이동 수행
        LinkedList<int[]> list = new LinkedList<>();    
        
        int time = 0;
        int weight =0; 
        int k = 0;
        
        while (true) {
            if (k == n && weight == 0) break;
            // printlist(list);
            
            time++;
            
            // 1. 다리 위 트럭 이동
            for (int i=0; i < list.size(); i++) {
                int[] curNode = list.get(i);
                int t = curNode[0];
                int d = curNode[1] + 1;
                
                if (d > w) {
                    weight -= t;
                    list.removeFirst();
                    i--; // 앞에 있는 원소를 삭제 > 모든 원소가 한칸 앞으로 당겨짐
                } else {
                    list.set(i, new int[] {t, d});
                }
            }
            
            // 2. 새로운 트럭 이동 OR PASS
            if (k < n && weight + arr[k] <= L) {
                weight += arr[k];
                list.add(new int[] {arr[k], 1});
                k++;
            }   
        }
        
        bw.write(time + "");
        bw.flush();
        br.close();
    }
    // public static void printlist(LinkedList<int[]> list) {
    //     for (int[] tmp : list) {
    //         System.out.print(Arrays.toString(tmp) + "  ");
    //     }
    //     System.out.println();
    // }
}