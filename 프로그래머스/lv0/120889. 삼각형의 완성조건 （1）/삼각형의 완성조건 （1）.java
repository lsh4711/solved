import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int max = 0;
        int sum = 0;
            
        for(int i=1; i<3; i++) {
            if(sides[max]<sides[i]) max = i;
        }
        for(int i=0; i<3; i++) {
            if(i != max) sum += sides[i];
        }
        
        if(sides[max]<sum) return 1;
        return 2;
    }
}