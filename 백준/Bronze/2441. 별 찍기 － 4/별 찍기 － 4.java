import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = nVal; i > 0; i--) {
            System.out.printf("%" + nVal + "s\n", "*".repeat(i));
        }

    }
}