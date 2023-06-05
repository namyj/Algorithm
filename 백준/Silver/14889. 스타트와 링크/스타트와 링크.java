import java.io.*;
import java.util.*;

/*
1. 스타트 팀에 가능한 조합 선택
2. S 합 계산 > 두 팀의 S 차이의 최소값
*/
public class Main {
    static int n;
    static int[][] arr;
    static int[] start;
    static int[] link;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        for (int i=0; i < n; i++) {    
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    
        visited = new boolean[n];
        start = new int[n/2];
        link = new int[n/2];
        
        permTeam(0, 0, n/2);
    
        bw.write(min + "");
        bw.flush();
        bw.close();
        br.close();
    }
    
    /*
    가능한 팀 조합 구하기
    */
    public static void permTeam(int s, int depth, int r) {
        if (depth == r) {
            int sIdx = 0;
            int lIdx = 0;
            for (int i=0; i<n; i++) {
                if (visited[i]) {
                    start[sIdx++] = i;
                } else {
                    link[lIdx++] = i;
                }
            }
            calc();
            return;
        }
        
        for (int i=s; i < n-1; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            permTeam(i, depth + 1, r);
            visited[i] = false;
        }
    }
    
    /* 
    팀 별 점수 계산 > 각 팀 점수 차이의 최소값 업데이트
    */
    public static void calc() {
        int startScore = 0;
        int linkScore = 0;
    
        for (int i=0; i < start.length-1; i++) {
            for (int j=i+1; j < start.length; j++) {
                int x = start[i];
                int y = start[j];
                startScore += (arr[x][y] + arr[y][x]);
            }
        }
        
        for (int i=0; i < link.length-1; i++) {
            for (int j=i+1; j < link.length; j++) {
                int x = link[i];
                int y = link[j];
                linkScore += (arr[x][y] + arr[y][x]);
            }
        }
        
        min = Math.min(min, Math.abs(startScore - linkScore));
    }
    
}
