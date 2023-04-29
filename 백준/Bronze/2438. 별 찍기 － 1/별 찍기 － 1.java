import java.util.Scanner;

/**
 * "문자열".repeat(숫자)
 * 문자열을 숫자만큼 반복해 붙인 결과를 출력
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = 0; i < nVal; i++) {
            System.out.println("*".repeat(i + 1));
        }

    }
}