import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[2000001];
        
        // c <= 100,0000 and c >= -100,0000  
        for (int i=0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            numList[c+1000000]++;
        }
        
        for (int i=numList.length-1; i >= 0; i--) {
            if (numList[i] > 0) {
                bw.write((i-1000000) + "\n");
                numList[i++]--;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }


}
