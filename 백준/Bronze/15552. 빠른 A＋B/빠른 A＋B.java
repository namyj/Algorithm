import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tVal = Integer.parseInt(br.readLine());
        String[] inputs;

        for (int i = 0; i < tVal; i++) {
            inputs = br.readLine().split(" ");
            bw.write(String.valueOf(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1])) + "\n");
        }
        
        bw.flush(); // 모든 결과를 버퍼에 저장 후 마지막에 출력

        br.close();
        bw.close();
    }
}