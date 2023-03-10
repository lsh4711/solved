import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numlist, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num : numlist) list.add(num);
        list.sort((i1, i2) -> {
            if(i1+i2 == n*2) return i2 - i1;
            return Math.abs(i1 - n) - Math.abs(i2 - n);
        });

        return list;
    }
}