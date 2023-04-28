import java.util.Scanner;

// Y Cost 조건
// 0~29 > 10
// 30~59 > 10 + 10
// M Cost 조건
// 0~59 > 15
// 60~119 > 15 + 15
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();
        int call;
        int yCost = 0;
        int mCost = 0;

        for (int i = 0; i < nVal ; i++) {
            call = sc.nextInt();
            yCost += 10 * (call / 30 + 1);
            mCost += 15 * (call / 60 + 1);
        }

        if (yCost == mCost) {
            System.out.printf("Y M %d", yCost);
        } else if (yCost < mCost) {
            System.out.printf("Y %d", yCost);
        } else {
            System.out.printf("M %d", mCost);
        }

    }
}