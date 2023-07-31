class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = (long)1e18;
        
        while(start < end) {
            long mid = (start + end) / 2;
            boolean isEnough = check(n, mid, times);
            if (!isEnough) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
    
    static boolean check(int n, long mid, int[] times) {
        long cnt = 0;
        
        for (int time : times) {
            cnt += mid / time;
            if (cnt >= n) {
                return true;
            }
        }
        
        return false;
    }
}