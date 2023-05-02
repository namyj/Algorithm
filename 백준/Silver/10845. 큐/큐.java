import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int head = 0; 
        int tail = 0;
        
        for (int i=0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            
            switch (command[0]) {
                case "push":
                    arr[tail++] = Integer.parseInt(command[1]);
                    break;
                case "pop":
                    if (tail - head > 0) {
                        bw.write(String.valueOf(arr[head++]) + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    if (tail - head > 0) {
                        bw.write(String.valueOf(tail - head) + "\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "empty":
                    if (tail - head > 0) {
                        bw.write("0\n");
                    } else {
                        bw.write("1\n");
                    }
                    break;
                case "front":
                    if (tail - head > 0) {
                        bw.write(String.valueOf(arr[head]) + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                default:
                    if (tail - head > 0) {
                        bw.write(String.valueOf(arr[tail - 1]) + "\n");
                    } else {
                        bw.write("-1\n");
                    }
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }    
}