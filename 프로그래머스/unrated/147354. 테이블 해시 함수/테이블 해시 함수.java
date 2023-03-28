import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int hash = 0;
        
        Arrays.sort(data, (arr1, arr2) -> {
                if(arr1[col - 1] != arr2[col - 1]) return arr1[col - 1] - arr2[col - 1];
                return arr2[0] - arr1[0];
        });
        for(int i = row_begin; i <= row_end; i++) {
            int si = 0;
            for(int j : data[i - 1]) si += j % i;
            hash ^= si;
        }
        
        return hash;
    }
}