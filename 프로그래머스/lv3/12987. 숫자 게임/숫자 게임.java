import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int result =  0;
        int aIdx = A.length - 1;
        int bIdx = B.length - 1;
        
        Arrays.sort(A);
        Arrays.sort(B);
        while (aIdx >= 0) {
            if (A[aIdx] >= B[bIdx]) {
                aIdx--;
                continue;
            }
            aIdx--;
            bIdx--;
            result++;
        }
        
        return result;
    }
}