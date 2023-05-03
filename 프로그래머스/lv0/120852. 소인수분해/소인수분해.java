class Solution {
    public boolean isPrime(int x) {
        for (int i = 2; i*i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public int[] solution(int n) {
        String result = new String();
        int factor = n;

        while (factor > 1) {
            if (isPrime(factor) && n % factor == 0) {
                result += (factor + " ");
            }
            factor--;
        }

        String[] resultArr = result.split(" ");
        int[] answer = new int[resultArr.length];
        for (int i = 0; i < resultArr.length ; i++) {
            answer[i] = Integer.parseInt(resultArr[resultArr.length - i - 1]);
        }

        return answer;
    }
}