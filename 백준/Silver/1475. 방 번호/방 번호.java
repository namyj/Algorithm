import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomNum = String.valueOf(sc.nextInt());
        int[] arr = new int[10]; // 0 ~ 9
        int setCnt = 0;

        int curNum;

        for (int i = 0; i < roomNum.length(); i++) {
            curNum = Integer.parseInt(roomNum.charAt(i) + "");
            
            if (curNum == 6 || curNum == 9) {
                if (arr[6] + arr[9] >= setCnt * 2) {
                    setCnt++;
                    arr[curNum]++;
                } else {
                    arr[curNum]++;
                }
            } else {
                if (arr[curNum] >= setCnt) {
                    setCnt++;
                    arr[curNum]++;
                } else {
                    arr[curNum]++;
                }
            }
        }

        System.out.println(setCnt);
    }
}
