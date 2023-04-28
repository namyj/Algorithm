import java.io.*;

/**
 * 입력 값 조건
 * 1 ≤ A, B ≤ 1000
 * 반례
 * - 두 수가 동일할 때
 * - 14 8 같이 앞에 수가 뒤에 수보다 작을 때
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);

        String[] iNum = br.readLine().split(" ");
        int cnt = Math.abs(Integer.parseInt(iNum[1]) - Integer.parseInt(iNum[0])) - 1;
        if (cnt < 0) cnt = 0;

        System.out.println(cnt);
        for (int i = 0 ; i < cnt; i++) {
            bw.write(String.valueOf(Math.min(Integer.parseInt(iNum[1]), Integer.parseInt(iNum[0])) + i + 1));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}