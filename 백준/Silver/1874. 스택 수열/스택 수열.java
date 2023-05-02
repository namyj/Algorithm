import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int pos = 1;
        boolean flag = true;
        
        
        for (int i=0; i < n; i++) {
            int curNum = Integer.parseInt(br.readLine());
            
            
            while (flag) {
                // 스택이 빈 경우 원소 삽입
                if (stack.isEmpty()) {
                    stack.push(pos++); 
                    sb.append("+\n");
                }
                
                if (stack.peek() == curNum) {
                    stack.pop();
                    sb.append("-\n");
                    break;
                } else if (stack.peek() > curNum) { // stack.peek() > curNum -> 불가능
                    flag = false;
                    break; 
                } else { 
                    stack.push(pos++); 
                    sb.append("+\n");     
                }
            }
            
            if (!flag) {
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}