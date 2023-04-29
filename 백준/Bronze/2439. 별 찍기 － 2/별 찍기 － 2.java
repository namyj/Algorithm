import java.util.Scanner;

/**
 * printf 형식 지정자 사용
 * %ns = n개의 공간 할당, 우측 정렬 (기본), 좌측 정렬 (n < 0)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();

        for (int i = 1; i <= nVal; i++) {
            System.out.printf("%" + nVal + "s\n", "*".repeat(i));
        }

    }
}
