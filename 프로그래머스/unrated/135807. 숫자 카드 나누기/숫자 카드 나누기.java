import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int maxA = 0;
        int maxB = 0;
        int max = Math.max(arrayA[arrayA.length - 1], arrayB[arrayB.length - 1]);
        
        label : for(int i = arrayA[0]; i > 1; i--) {
            for(int a : arrayA) {
                if(a % i != 0) continue label;
            }
            for(int b : arrayB) {
                if(b % i == 0) continue label;
            }
            maxA = i;
            break;
        }
        label : for(int i = arrayB[0]; i > 1; i--) {
            for(int b : arrayB) {
                if(b % i != 0) continue label;
            }
            for(int a : arrayA) {
                if(a % i == 0) continue label;
            }
            maxB = i;
            break;
        }
        
        return Math.max(maxA, maxB);
    }
}