import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 접근법
 * - 방문한 원소를 삭제 > 연결 리스트 사용
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int nVal = Integer.parseInt(input[0]);
        int kVal = Integer.parseInt(input[1]);

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nVal; i++) {
            list.add(i + 1);
        }

        ListIterator<Integer> iter = list.listIterator(); // iter = 리스트 맨 앞
        int cnt = 0;
        int index = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (list.size() > 0) {
            if (iter.hasNext()) {
                index = iter.nextIndex();
                iter.next();
                cnt++;

                if (cnt >= kVal) {
                    // bw.write(String.valueOf(list.get(index)) + ", ");
                    sb.append(String.valueOf(list.get(index)) + ", ");
                    cnt = 0;
                    iter.remove();
                }
            } else {
                iter = list.listIterator(0);
            }
        }

        sb.replace(sb.length()-2, sb.length(), ">");
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();

    }
}
