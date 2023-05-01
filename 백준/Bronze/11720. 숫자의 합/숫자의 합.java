import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nVal = sc.nextInt();
        sc.nextLine();
        char[] input = sc.nextLine().toCharArray();
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += (input[i] - 48);
        }
        System.out.println(sum);
    }
}
