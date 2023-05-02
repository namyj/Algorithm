import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int pos = 0;
        
        for (int i=0; i < k; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            if (inputNum == 0) {
                stack.pop();
            } else {
                stack.push(inputNum);
            }
        }
        
        while (!stack.empty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}