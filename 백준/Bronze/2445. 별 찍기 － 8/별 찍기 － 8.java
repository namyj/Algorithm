import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = 1; i <= nVal ; i++) {
            System.out.printf("%-" + nVal + "s", "*".repeat(i));
            System.out.printf("%" + nVal + "s\n", "*".repeat(i));
        }

        for (int i = nVal - 1; i > 0; i--) {
            System.out.printf("%-" + nVal + "s", "*".repeat(i));
            System.out.printf("%" + nVal + "s\n", "*".repeat(i));
        }
    }
}
