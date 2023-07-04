import java.util.Arrays;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int result = 0;
        int pickCount = picks[0] + picks[1] + picks[2];
        int min = Math.min((minerals.length + 4) / 5, pickCount);
        int[][] stacks = new int[min][3];
        
        for (int i = 0; i < minerals.length; i++) {
            int idx = i / 5;
            if (idx == min) {
                break;
            }
            String mineral = minerals[i];
            if (mineral.length() == 7) {
                stacks[idx][0]++;
            } else if (mineral.length() == 4) {
                stacks[idx][1]++;
            } else {
                stacks[idx][2]++;
            }
        }
        Arrays.sort(stacks, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                if (a1[1] == a2[1]) {
                    return a2[2] - a1[2];
                }
                return a2[1] - a1[1];
            }
            return a2[0] - a1[0];
        });
        for (int i = 0; i < stacks.length; i++) {
            int[] stack = stacks[i];
            if (picks[0]-- > 0) {
                result += stack[0] + stack[1] + stack[2];
            } else if (picks[1]-- > 0) {
                result += stack[0] * 5 + stack[1] + stack[2];
            } else if (picks[2]-- > 0) {
                result += stack[0] * 25 + stack[1] * 5 + stack[2];
            }
        }
        
        return result;
    }
}