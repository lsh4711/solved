import java.util.Arrays;

class Solution {
    public Integer[] solution(int[] numlist, int n) {
        Integer[] copy = new Integer[numlist.length];
        
        for (int i = 0; i < numlist.length; i++) {
            copy[i] = numlist[i];
        }
        
        Arrays.sort(copy, (i1, i2) -> {
            int a1 = Math.abs(i1 - n);
            int a2 = Math.abs(i2 - n);
            
            if (a1 == a2) {
                return i2 - i1;
            }
            return a1 - a2;
        });
        
        return copy;
    }
}