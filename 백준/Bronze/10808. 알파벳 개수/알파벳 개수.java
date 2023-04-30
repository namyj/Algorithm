import java.util.Scanner;

/**
 * a의 아스키 코드값 = 97
 * b // = 98
 * c // = 99
 * 접근법
 * - 총 26 개 알파벳의 개수를 저장할 정수 배열 생성
 * - 입력 문자열을 한 문자씩 돌아가며 'c' - 97 > 해당 인덱스값을 +1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] alphCount = new int[26];

        for (int i = 0; i < str.length(); i++) {
            alphCount[(int) str.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < alphCount.length; i++) {
            System.out.printf("%d ", alphCount[i]);
        }

    }
}

