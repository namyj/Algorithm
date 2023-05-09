import java.io.*;
import java.util.*;

public class Main {
    // public static int cnt = 0;
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static LinkedList<int[]> result = new LinkedList<>();
    public static void move(int s, int e, int from, int to) throws IOException {
        if (s == e) {
            // cnt++;
            // bw.write(from + " " + to + "\n");
            result.add(new int[] {from, to});
            return;
        }
        
        int mid = 6 - (from + to);
        move(s, e-1, from, mid);
        
        // 맨 밑 칸 이동
        // bw.write(from + " " + to + "\n");
        // cnt++;
        result.add(new int[] {from, to});
        
        move(s, e-1, mid, to);
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        move(1, n, 1, 3);
        
        bw.write(result.size() + "\n");
        Iterator<int[]> iter = result.listIterator();
        while (iter.hasNext()) {
            int[] tmp = iter.next(); 
            bw.write(tmp[0] + " " + tmp[1] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}