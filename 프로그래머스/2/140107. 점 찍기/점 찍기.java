class Solution {
    public long solution(int k, int d) {
        long result = 0;
        long square = (long)d * d;

        for(long i = 0; i <= d; i += k) {
            result += (long)Math.sqrt(square - i * i) / k + 1;
        }

        return result;
    }
}