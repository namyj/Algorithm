import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        
        // 1. 큐에 모든 정수 삽입
        for (int i=1; i <= n; i++) {
            q.add(i);
        }
        
        // 2. 큐에 원소가 하나 남을 때까지 동작 수행
        while (q.size() > 1) {
            q.poll();
            if (q.size() <= 1)
                break;
            
            q.offer(q.poll());
        }
        
        bw.write(String.valueOf(q.poll()));
        bw.flush();
        br.close();
        bw.close();
    
    }
}