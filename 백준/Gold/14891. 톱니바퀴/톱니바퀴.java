import java.io.*;
import java.util.*;

/*
- 톱니바퀴 마지막 원소의 인덱스 7
- 톱니를 돌리기 전에 극을 저장
*/
public class Main {
    static int n; // 회전 횟수
    static int[][] arr = new int[4][];
    static int answer = 0;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        for (int i=0; i < 4; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();    
        }
        
        
        n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++){
            String[] inputs = br.readLine().split(" ");
            int k = Integer.parseInt(inputs[0]);
            int d = Integer.parseInt(inputs[1]);
            
            visited = new boolean[4];
            spin(k-1, d);
            
        }
        
        score();
        bw.write(answer + "");
        bw.close();
        br.close();
        
    }
    
    // 회전
    public static void spin(int k, int d) {
        visited[k] = true;
            
        // 인접 톱니 회전
        // 인접한 톱니 & 회전한 적 없는 경우 & 극이 다른 경우        
        if (k-1 >= 0 && !visited[k-1] && arr[k-1][2] != arr[k][6]) {
            visited[k-1] = true;
            spin(k-1, d*(-1));
        }
        
        if (k+1 < 4 && !visited[k+1] && arr[k][2] != arr[k+1][6]) {
            visited[k+1] = true;
            spin(k+1, d*(-1));
        }
        
        // k번 톱니 회전
        if (d > 0) { // 시계
            int before = arr[k][7];
            
            for (int i=0; i < 7; i++) {
                int tmp = arr[k][i];
                arr[k][i] = before;
                before = tmp;
            }
            arr[k][7] = before;
            
        } else {    // 반시계
            int before = arr[k][0];
            
            for (int i= 7; i > 0 ; i--) {
                int tmp = arr[k][i];
                arr[k][i] = before;
                before = tmp;
            }
            arr[k][0] = before; 
        }
        
    }
    
    // 점수 계산
    public static void score() {
        for (int i=0; i < 4; i++) {
            if (arr[i][0] == 1) {
                answer += Math.pow(2, i);
            }
        }
    }
}