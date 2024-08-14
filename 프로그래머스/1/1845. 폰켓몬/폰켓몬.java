import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int available = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        return Math.min(set.size(), available);
    }
}