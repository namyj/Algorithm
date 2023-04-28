import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int min = 100;
        int inputNum;

        for (int i = 0; i < 7; i++) {
            inputNum = sc.nextInt();
            if (inputNum % 2 == 1) { // 홀수 필터링
                sum += inputNum;
                min = min > inputNum? inputNum : min;
            }
        }

        if (sum == 0) { // 홀수가 없는 경우
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
