import java.util.Scanner;

// 중앙값 구하기
// 입력 값 정렬 > 길이/2 번째 인덱스 값
// 입력값 배열에 저장 > 버블 정렬
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] iArr = new int[5];

        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = sc.nextInt();
            sum += iArr[i];
        }

        for (int i = 0; i < iArr.length - 1 ; i++) {
            for (int j = i + 1; j < iArr.length; j++) {
                if (iArr[i] > iArr[j]) {
                    int temp = iArr[i];
                    iArr[i] = iArr[j];
                    iArr[j] = temp;
                }
            }
        }

        System.out.println(sum / iArr.length); // 평균
        System.out.println(iArr[iArr.length/2]); // 중앙값

    }
}