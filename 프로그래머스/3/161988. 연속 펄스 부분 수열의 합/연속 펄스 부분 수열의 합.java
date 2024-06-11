import java.util.ArrayList;

class Solution {
    public long solution(int[] sequence) {
        int[] copy1 = combinePulse(sequence.clone(), -1);
        int[] copy2 = combinePulse(sequence.clone(), 1);
        
        return Math.max(getMax(copy1), getMax(copy2));
    }
    
    private int[] combinePulse(int[] array, int basePulseNumber) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= basePulseNumber;
            basePulseNumber *= -1;
        }
        
        return array;
    }
    
    private long getMax(int[] array) {
        ArrayList<Long> list = new ArrayList<>();
        long sum = 0;
        
        for (int num : array) {
            if (sum < 0 && num > 0
               || sum > 0 && num < 0) {
                list.add(sum);
                sum = 0;
            }
            sum += num;
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