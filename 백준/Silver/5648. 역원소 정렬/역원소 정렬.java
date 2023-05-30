import java.io.*;
import java.util.*;

/*
- 입력을 EOF 까지 받기 > LinkedList 저장
- 숫자 뒤집기 > 오름차순 정렬
- 뒤집었을 때 앞에 있는 0은 제거
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st;
        StringBuffer sb;
        
        long n;
        boolean start = true;
        String str = "";
        
        LinkedList<Long> arr = new LinkedList<>();
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            
            if (start) {
                n = Long.parseLong(st.nextToken());
                start = false;
            }
            
            while (st.hasMoreTokens()) {
                sb = new StringBuffer(st.nextToken());
                arr.add(Long.parseLong(sb.reverse().toString()));
            }
        }
        
        Collections.sort(arr);
        
        Iterator<Long> iter = arr.iterator();
        for (int i=0; i < arr.size(); i++) {
            bw.write(iter.next() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
