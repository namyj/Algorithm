import java.util.Scanner;

/**
 * 입력 값 조건
 * 1 ≤ A, B ≤ 1000
 * 반례
 * - 두 수가 동일할 때
 * - 14 8 같이 앞에 수가 뒤에 수보다 작을 때
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNum = sc.nextInt();
        int bNum = sc.nextInt();
        int cnt = Math.abs(bNum - aNum) - 1;

        if (cnt < 0) cnt = 0; // 두 수가 동일할 때

        System.out.println(cnt); 
        for (int i = 0 ; i < cnt; i++) {
            System.out.printf("%d ", Math.min(aNum, bNum) + i + 1);
        }
    }
}