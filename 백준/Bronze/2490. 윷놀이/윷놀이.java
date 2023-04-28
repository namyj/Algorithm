import java.util.Scanner;
// 입력: 네 개 윷짝의 정보(0 = 배 1 = 등), 세 줄
// 출력: 윷 짝을 해석한 결과 (도는 A, 개는 B, 걸은 C, 윷은 D, 모는 E)
// 윷짝 해석
// 도 = 1 3개 > A
// 개 = 1 2개 > B
// 걸 = 1 1개 > C
// 윷 = 1 0개 > D
// 모 = 1 4개 > E
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum;
        String[][] inputs = new String[3][4];

        for (int i = 0; i < inputs.length ; i++) {
            inputs[i] = sc.nextLine().split(" ");
        }

        for (int i = 0; i < inputs.length; i++) {
            sum = 0;

            for (int j = 0; j < inputs[i].length; j++) {
                sum += Integer.parseInt(inputs[i][j]);
            }

            switch (sum) {
                case 3:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                case 0:
                    System.out.println("D");
                    break;
                default:
                    System.out.println("E");
                    break;
            }
        }
    }
}