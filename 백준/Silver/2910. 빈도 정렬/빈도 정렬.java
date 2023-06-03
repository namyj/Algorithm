import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
- 빈도 순 > 초기 위치 순

숫자 , 빈도, 입력 순서

LinkedHashMap
- Map에 입력한 순서가 보장되는 클래스

*/
public class Main {
    static int n;
    static Map<Long, Integer> map; // <수, 빈도>
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        Long.parseLong(st.nextToken()); // c 사용 x
        
        map = new LinkedHashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) {
            long num = Long.parseLong(st.nextToken());
            
            if (map.containsKey(num)) {
                int tmp = map.get(num);
                map.replace(num, tmp + 1);
            } else {
                map.put(num, 1);   
            }
        }
        
        List<Map.Entry<Long, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        
        for (Map.Entry<Long, Integer> entry : list) {
            for (int i=0; i< entry.getValue(); i++) {
                bw.write(entry.getKey() + " ");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

}
