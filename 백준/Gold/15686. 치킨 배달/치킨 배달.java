import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int answer;
    
    static int[][] chickens;
    static int[][] houses;
    static int cidx;
    static int hidx;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        chickens = new int[13][2];
        houses = new int[2*n][2];
        answer = Integer.MAX_VALUE;
        
        cidx = 0;
        hidx = 0;
        for (int i=1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                
                if (tmp == 2) { // 치킨집
                    chickens[cidx++] = new int[] {i, j};
                } else if (tmp == 1) { // 집
                    houses[hidx++] = new int[] {i, j};                    
                }
            }
        }
        
        
        visited = new boolean[cidx];
        search(0, 0);
        
        bw.write(answer + "");
        bw.flush();
        br.close();
    }
    
    public static void search(int k, int start) {
        // 치킨집 선택 완료 > 각 집과 거리 계산
        if (k == m) {  
            int total = 0;
            for (int i=0; i < hidx; i++) {
                int min = 2 * n;
                for(int j=0; j < cidx; j++) {
                    if (visited[j] == false) continue;
                    
                    // 선택된 치킨집인 경우 > 거리 계산
                    min = Math.min(min, distance(houses[i], chickens[j]));
                }
                total += min;
            }
            
            answer = Math.min(answer, total);
            return;
        }

        // 치킨집 선택
        for (int i=start; i < cidx; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                search(k + 1, i+1);
                visited[i] = false;
            }         
        }
    }
    
    
    // 거리 계산
    public static int distance(int[] house, int[] chicken) {
        return Math.abs(house[0]-chicken[0]) + Math.abs(house[1]-chicken[1]); 
    }
}