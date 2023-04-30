import java.util.Scanner;

/**
 * 2442의 반대
 * 각 줄에 N 과 N-1찍기
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = nVal; i > 0; i--) {
            System.out.printf("%" + nVal + "s", "*".repeat(i));
            System.out.printf("%s\n", "*".repeat(i-1));
        }
    }
}