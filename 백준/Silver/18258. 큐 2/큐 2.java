import java.util.*;
import java.io.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        
        for (int i=0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            
            switch (command[0]) {
                case "push": 
                    q.offer(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if (!q.isEmpty()) {
                        bw.write(String.valueOf(q.poll()) + "\n");
                    } else {
                        bw.write("-1\n"); 
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(q.size()) + "\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(String.valueOf(q.peek()) + "\n");
                    }
                    break;
                default: // back
                    if (q.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        // bw.write(String.valueOf(q.toArray()[q.size() - 1]) + "\n");
                        bw.write(q.peekLast()+ "\n");
                    }
            }   
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}