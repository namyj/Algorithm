import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mVal = 1;
        for (int i = 0; i < 3; i++) {
            mVal *= sc.nextInt();
        }

        int[] count = new int[10];
        String strVal = String.valueOf(mVal);

        for (int i = 0; i < strVal.length(); i++) {
            count[Integer.parseInt(strVal.charAt(i) + "")] += 1;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }
}
