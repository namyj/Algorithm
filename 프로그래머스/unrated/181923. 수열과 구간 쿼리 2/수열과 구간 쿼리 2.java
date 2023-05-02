class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int min;
        
        for (int i = 0; i < queries.length ; i++) { // 각 쿼리 수행

            min = -1;

            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (arr[j] > queries[i][2]) { // k 보다 큰 경우
                    if (min < 0) {
                        min = arr[j];
                    } else {
                        min = arr[j] < min? arr[j] : min;
                    }
                }
            }

            answer[i] = min;
        }

        return answer;
    }
}