import java.util.Scanner;

/**
 * 입력: 자연수 (1 이상)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 1;
        int cnt = 0;
        int input;

        for (int i = 0; i < 9; i++) {
            input = sc.nextInt();
            if (input > max) {
                max = input;
                cnt = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(cnt);

    }
}
