import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        int pos = 0;
        
        for (int i=0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    arr[pos++] = Integer.parseInt(command[1]);
                    break;
                case "pop":
                    if (pos <= 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arr[--pos]);
                    }
                    break;
                case "size":
                    System.out.println(pos);
                    break;
                case "empty":
                    if (pos <= 0) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if (pos <= 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arr[pos-1]);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}