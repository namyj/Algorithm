import java.io.*;
import java.util.*;

public class Main {
    public static String divide(int l, int r) {
        if (l==r) return "-";
        
        int mid = (r - l + 1) / 3; // 분할 리스트 당 원소 개수
        
        return divide(l, l+mid-1) + " ".repeat(mid) + divide(r - mid + 1, r);
        
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = "";
        int n;
        while ((input = br.readLine()) != null ) {
            n = Integer.parseInt(input);
            
            System.out.println(divide(0, (int) Math.pow(3, n) - 1));
        }
    }
}