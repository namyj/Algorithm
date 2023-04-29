
import java.util.Scanner;

/**
 * - 2439와 동일하게 printf 형식 지정자 사용 > 오답, 빈칸을 포함해서 출력하기 때문
 * - repeat 만 사용해 출력
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = nVal; i > 0; i--) {
            System.out.println("*".repeat(i));
        }

    }
}