// "static void main" must be defined in a public class.

import java.io.*;
import java.util.*;

/*
Arrays.sort()
- 2 차원 배열을 그냥 정렬하면 java.lang.ClassCastException: class [I cannot be cast to class java.lang.Comparable 에러 발생
    > Comparable,Comparator 인터페이스를 구현하여 정렬기준을 추가헤줘야한다. 
*/
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
        
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] != o2[0]? o1[0]-o2[0] : o1[1]-o2[1] ;
        });
        
        for (int i=0; i < arr.length; i++) {
            bw.write(arr[i][0] + " " + arr[i][1]+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}