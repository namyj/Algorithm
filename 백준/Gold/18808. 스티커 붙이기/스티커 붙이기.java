import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        
        // 스티커 입력 > 붙이기
        for (int i=0; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[r][c];
            for (int x=0; x < r ; x++) {
                sticker[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            
            search(sticker);
        }
        
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 스티커 붙일 위치 찾기
    public static void search(int[][] sticker) {
        // 반복문 안에서 r, c 값을 얻어옴
        // 이유: 초기에 입력 받은 r, c 가 스티커를 회전할 때마다 바뀌게 된다 (이걸로 계속 고생함)
        int r, c; 
        
        
        for (int d=0; d < 4; d++) {
            r = sticker.length;
            c = sticker[0].length;
            for (int i=0; i < N; i++) {
                for (int j=0; j < M; j++) {
                    // 스티커가 map 범위를 벗어남 > 다른 위치 찾기
                    if (i + r > N || j + c > M) break;
                    
                    // 스티커 붙이기 성공 > 탐색 종료
                    if (put(sticker, i, j)) {
                        return;
                    }
                }
            }
            sticker = rotate(sticker, r, c);
        }
        
    }
    
    // (x, y) 부터 스티커 붙이기
    public static boolean put(int[][] sticker, int x, int y) {
        int r = sticker.length;
        int c = sticker[0].length;
        
        for (int i=0; i < r ; i++) {
            for (int j=0; j < c ; j++) {
                if (sticker[i][j] == 1 && arr[x+i][y+j] == 1) 
                    return false;
            }
        }
        
        // 스티커 붙이기 가능
        // 원본 배열에 반영해주기
        for (int i=0; i < r; i++) {
            for (int j=0; j < c; j++) {
                if (sticker[i][j] == 1) {
                    arr[x+i][y+j] = 1;
                    result++;
                }
            }
        } 
    
        return true;
    }
    
    // 스티커 회전
    public static int[][] rotate(int[][] sticker, int r, int c) {      
        int[][] tmp = new int[c][r];
        
        for (int i=0; i < r; i++){
            for (int j=0; j < c; j++) {
                tmp[j][r - i - 1] = sticker[i][j];
            }
        }
        
        return tmp;
    }
}