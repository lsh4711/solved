import java.util.Arrays;

class Solution {
    public long solution(int n, int[] works) {
        long result = 0;
        int idx = works.length - 1;
        
        Arrays.sort(works);
        while (n > 0) {
            int target = idx;
            int before = works[idx - 1];
            int now = works[idx];
            
            if (before > now) {
                if (idx > 1) {
                    idx--;
                    continue;
                }
                target--;
            } else if (idx < works.length - 1 && now <= works[idx + 1]) {
                idx++;
                continue;
            }
            if (works[target] == 0) {
                break;
            }
            works[target]--;
            n--;
        }
        for (int work : works) {
            result += work * work;
        }
        
        return result;
    }
}   