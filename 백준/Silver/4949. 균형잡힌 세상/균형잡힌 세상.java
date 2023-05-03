import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack;
        
        while (true) {
            String input = br.readLine(); 
            if (input.equals(".")) { // 종료
                break;
            } 
            
            input = input.replaceAll("[a-zA-Z.\\s]", ""); // 괄호만 남기고 제거
            stack = new Stack<>();
            
            boolean flag = true; // 문장의 균형 여부 
            int i = 0;
            
            while (flag && i < input.length()) {
                switch (input.charAt(i++)) {
                    case '(': // push
                        stack.push('(');
                        break;
                    case '[': // push
                        stack.push('[');
                        break;
                    case ')': // pop
                        if (stack.empty() || stack.peek() != '(') {
                            flag = false;
                        } else {
                            stack.pop();
                        }
                        break;
                    case ']': // pop
                        if (stack.empty() || stack.peek() != '[') {
                            flag = false;
                        } else {
                            stack.pop();
                        }
                        break;
                    default:
                        break;
                }
            }
            
            if (flag && stack.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}