class Solution {
    public int solution(int[] stones, int k) {
        int start = 1;
        int end = (int)2e8;
        
        label : while (start < end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int stone : stones) {
                if (stone <= mid) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                if (cnt >= k) {
                    end = mid;
                    continue label;
                }
            }
            start = mid + 1;
        }
        
        return start;
    }
}
