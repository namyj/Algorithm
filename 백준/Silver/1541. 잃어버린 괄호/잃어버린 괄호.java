import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputs = br.readLine().replace("-", " -");
        inputs = inputs.replace("+", " +");
        
        StringTokenizer st = new StringTokenizer(inputs);

        int result = 0;
        boolean isMinus = false;        
        
        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            
            if (tmp < 0) {
                result += tmp;
                isMinus = true;
            } else if (isMinus) {
                result -= tmp;
            } else {
                result += tmp;
            }
        }

        System.out.println(result);
    }
}