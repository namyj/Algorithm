import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        // 디큐 생성 및 초기화
        LinkedList<Integer> dq = new LinkedList<>();
        
        for (int i=1; i <= n ; i++) {
            dq.offer(i);
        }
            
        // 찾을 숫자 
        input = br.readLine().split(" ");
        int cnt = 0; 
        
        for (int i=0; i < m; i++) {
            int curNum = Integer.parseInt(input[i]);
            int idx = dq.indexOf(curNum);
            
            if (idx <= dq.size() / 2) { // 2 연산
                while (dq.peek() != curNum) {
                    cnt++;
                    int tmp = dq.pollFirst();
                    dq.offerLast(tmp);
                }    
            } else { // 3 연산
                while (dq.peek() != curNum) {
                    cnt++;
                    int tmp = dq.pollLast();
                    dq.offerFirst(tmp);
                }  
            }
            dq.pollFirst();
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    
    }
}