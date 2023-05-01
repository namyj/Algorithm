import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수
        int nVal = Integer.parseInt(br.readLine());
        String inStr;
        LinkedList<Character> list;

        for (int i = 0; i < nVal; i++) {
            // 2. 케이스 입력 받기
            inStr = br.readLine();

            // 2-1. 문자열 > 연결 리스트
            list = new LinkedList<Character>();
            ListIterator<Character> iter = list.listIterator(); // iter : 맨 처음부터
            
            // 3. 각 문자를 돌면서 로그 해독
            for (int j = 0; j < inStr.length(); j++) {
                char chr = inStr.charAt(j);

                switch (chr) {
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(chr);
                        break;
                }

                
            }
            
            // 4. 버퍼에 비밀번호 적기
            for (Character outChr : list) {
                bw.write(outChr);
            }

            bw.write('\n');
        }

        // 5. 버퍼 출력
        bw.flush();
        bw.close();
        br.close();
    }
}
