class Solution {
    public int solution(int n) {
        // 주의) n = 0
        int answer = 0 + n; // 기본적으로 1,자기 자신은 약수
        for (int i = 1; i < n ; i++) {
            if (n % i == 0)
                answer += i;
        }

        return answer;
    }
}