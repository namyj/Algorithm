import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        int goodWord = 0;
        
        for (int i=0; i < n ; i++) {
            String input = br.readLine();
            stack = new Stack<>();
            
            for (int j=0; j < input.length(); j++) {
                switch(input.charAt(j)) {
                    case 'A':
                        if (!stack.isEmpty() && stack.peek() == 'A') {
                            stack.pop();
                        } else {
                            stack.push('A');
                        }
                        break;
                    case 'B':
                        if (!stack.isEmpty() && stack.peek() == 'B') {
                            stack.pop();
                        } else {
                            stack.push('B');
                        }
                        break;
                    default:
                        break;
                }    
            }
            
            if (stack.isEmpty()) {
                goodWord++;
            } 
        }
        
        bw.write(String.valueOf(goodWord));
        bw.flush();
        bw.close();
        br.close();
        
    }
}