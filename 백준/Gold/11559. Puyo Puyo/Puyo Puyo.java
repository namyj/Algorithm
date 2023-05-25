
import java.io.*;
import java.util.*;

/*
1. 시작점 찾기
2. 시작점부터 인접한 블록(뿌요) 탐색 - bfs
3. 인접한 블록 개수가 4 개 이상이면 > 연쇄 / 4 개 미만이면 > 이어서 시작점 찾기 
4. 연쇄
    - 인접한 블록들을 삭제
    - 블록이 삭제된 빈 공간에 위에 있는 블록들 밀기 (아래로 밀기)
5. 연쇄가 발생한 경우, 처음부터 다시 시작점 찾기

참고하기 : https://www.acmicpc.net/source/share/dbbdb027f842424988616832c3686ca1
참고한 정답: https://moonsbeen.tistory.com/213
*/
public class Main {
    static int answer = 0; // 연쇄 횟수
    static Character[][] arr = new Character[12][6];
    static int[][] pos =  {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static ArrayList<int[]> list; // 인접 블록 좌표 저장
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        for (int i=0; i < 12; i++) {
            String input = br.readLine();
            for (int j=0; j < 6; j++) {
                arr[i][j] = input.charAt(j);
            }   
        }

        search();
        
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 시작점 찾고 입접 블록 찾기 - bfs
    // 인접 블록이 4 개 이상인지 확인 > 4개 이 상이면 블록 제거 - remove
    // 현 상황에서 제거할 수 있는 블록을 모두 지우고 > 블록 아래로 밀기 - push
    public static void search() {
        boolean flag = true;
        while(flag) {
            flag = false; // 연쇄 발생 여부
        
            for (int i=0; i < 12; i++) {
                for (int j=0; j < 6; j++) {
                    if (arr[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(i, j);
                        
                        if(list.size() >= 4) { // 연쇄 발생
                            remove();
                            flag = true;
                        }
                    }
                }
            }
            
            // 모든 맵을 돌아도 연쇄가 발생하지 않은 경우 > 종료
            // 연쇄가 발생한 경우 > 다시 시작점 찾기
            if (flag) {
                answer++;
                push();
            }    
        }
    }
    
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];
        
        q.add(new int[]{x, y});
        visited[x][y] = true;
        list.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.poll()[1];
            
            for (int d=0; d<4; d++) {
                int nx = cx + pos[d][0];
                int ny = cy + pos[d][1];
                
                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                if (visited[nx][ny]) continue;
                
                if (arr[nx][ny] == arr[x][y]) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    list.add(new int[]{nx, ny});
                }
            }
        }
    }
    
    // 인접한 블록 제거 > 나머지 블록 아래로 밀기
    public static void remove() {
        for (int i=0; i < list.size() ; i++) {
            arr[list.get(i)[0]][list.get(i)[1]] = '.';
        }
    }
    
    public static void push() {
        for (int i=0; i < 6; i++) {
            for (int j=11; j >= 0; j--) { 
                if (arr[j][i] == '.') {
                    for (int k=j-1; k >= 0; k--) { // 빈칸 윗 칸부터 아래로 밀기
                        if (arr[k][i] != '.') {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '.';   
                            break;
                        }
                    }
                }
            }
        }
    }
    
    
}