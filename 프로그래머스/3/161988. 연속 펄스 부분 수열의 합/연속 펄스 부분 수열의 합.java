import java.util.ArrayList;

class Solution {
    public long solution(int[] sequence) {
        return Math.max(getMax(sequence, -1), getMax(sequence, 1));
    }
    
    private long getMax(int[] array, int basePulseNumber) {
        ArrayList<Long> list = new ArrayList<>();
        long sum = 0;
        
        for (int num : array) {
            num *= basePulseNumber;
            if (sum < 0 && num > 0
               || sum > 0 && num < 0) {
                list.add(sum);
                sum = 0;
            }
            sum += num;
            basePulseNumber *= -1;
        }
        
        list.add(sum);
        
        sum = 0;
        long max = 0;
        
        for (long num : list) {
            if (sum + num <= 0) {
                sum = 0;
                continue;
            }
            sum += num;
            max = Math.max(max, sum);
        }
        
        return max;
    }
}