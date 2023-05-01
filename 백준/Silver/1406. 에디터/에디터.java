import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 접근법
 * - 문자열, 커서 포인터 사용 > 오답
 * - 연결 리스트 > 시간초과
 * - 연결 리스트 + ListIterator
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문자열 > 연결 리스트
        String inStr = br.readLine(); // 각 문자로 쪼개기
        LinkedList<Character> list = new LinkedList<Character>();
        ListIterator<Character> iter = list.listIterator();

        for (int i = 0; i < inStr.length() ; i++) {
            iter.add(inStr.charAt(i));
        }
        int cursor = list.size();

        // 2. 명령어 개수
        int nVal = Integer.parseInt(br.readLine());

        // 3. 명령어 수행
        for (int i = 0; i < nVal ; i++) {
            String comman = br.readLine();

            switch(comman.charAt(0)) {
                case 'L': // 커서 좌측으로 한 칸 이동 = 연결 리스트 인덱스 한칸 이동
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'D': // 커서 우측으로 한칸 이동 = 연결 리스트 인덱스 한칸 이동
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'B': // 커서 왼쪽 원소 삭제 후 커서 왼쪽으로 한 칸 이동 = 연결 리스트 원소 삭제(remove) 후, 인덱스 한칸 이동
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P': // 커서 왼쪽에 원소 삽입 후 커서 오른쪽으로 한 칸 이동 = 연결 리스트 원소 삽입(add) 후, 인덱스 한칸 이동
                    iter.add(comman.charAt(2));
                    break;
                default:
                    break;
            }
        }

        // 3. 결과 출력
        for (Character chr : list) {
            bw.write(chr);
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
