// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][];

        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {x, y};
        }
        
        // Y 좌표 > X 좌표 기준 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            return o1[1] != o2[1]? o1[1]-o2[1] : o1[0]-o2[0] ;
        });
        
        for (int i=0; i < arr.length; i++) {
            bw.write(arr[i][0] + " " + arr[i][1]+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}