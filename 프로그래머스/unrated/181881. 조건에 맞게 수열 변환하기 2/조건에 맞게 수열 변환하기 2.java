class Solution {
    public int solution(int[] arr) {
        int cnt = 0;
        
        while (true) {
            if (isSameAfterConvert(arr)) {
                return cnt;
            }
            cnt++;
        }
        
    }
    
    static boolean isSameAfterConvert(int[] arr) {
        int cnt = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            if (now >= 50 && now % 2 == 2) {
                now /= 2;
            } else if (now < 50 && now % 2 == 1) {
                now = now * 2 + 1;
            }
            if (now == arr[i]) {
                cnt++;
            }
            arr[i] = now;
        }
        
        if (cnt == arr.length) {
            return true;
        }
        return false;
    }
}