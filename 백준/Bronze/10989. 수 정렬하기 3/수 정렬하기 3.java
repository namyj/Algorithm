
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
Counting sort
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[10000001];
        
        for (int i=0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            numList[c]++;
        }
        
        for (int i=0; i < numList.length; i++) {
            if (numList[i] > 0) {
                numList[i]--;
                bw.write(i-- + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }


}
