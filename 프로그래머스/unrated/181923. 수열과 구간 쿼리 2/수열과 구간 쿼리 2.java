class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int min = -1;
            int[] query = queries[i];
            int s = query[0];
            int e = query[1];
            int k = query[2];
            for (int j = s; j < arr.length && j <= e; j++) {
                int now = arr[j];
                if (now <= k) {
                    continue;
                }
                if (min == -1 || now < min) {
                    min = now;
                }
            }
            result[i] = min;
        }
         
        return result;
    }
}