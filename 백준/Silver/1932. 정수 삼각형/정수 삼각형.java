import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<int[]> numlist;
    static ArrayList<int[]> D;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        numlist = new ArrayList<>();
        
        for (int i=0; i < n; i++) {
            numlist.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());           
        }
        
        // 초기값 정의
        // D[0] // 1 층
        D = (ArrayList<int[]>) numlist.clone();
        
        for (int i=1; i < n; i++) {
            int[] curLayer = numlist.get(i);
            D.get(i)[0] = curLayer[0] + D.get(i-1)[0];
            D.get(i)[curLayer.length-1] = curLayer[curLayer.length-1] + D.get(i-1)[curLayer.length-2];
            for (int j=1; j < curLayer.length -1 ; j++) {
                D.get(i)[j] = curLayer[j] + Math.max(D.get(i-1)[j], D.get(i-1)[j-1]);
            }
        }
        
        int result = 0;
        for (int i=0; i < D.get(n-1).length; i++ ) {
            result = Math.max(result, D.get(n-1)[i]);            
        }
        
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
	}  
}