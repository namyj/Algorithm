import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = nVal; i > 0 ; i--) {
            System.out.printf("%" + nVal + "s", "*".repeat(i));
            System.out.printf("%s\n", "*".repeat(i-1));
        }

        for (int i = 2; i <= nVal; i++) {
            System.out.printf("%" + nVal + "s", "*".repeat(i));
            System.out.printf("%s\n", "*".repeat(i-1));
        }
    }
}
