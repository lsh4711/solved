import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            result[i] = getKNum(array, command);
        }
        
        return result;
    }
    
    private int getKNum(int[] numbers, int[] command) {
        int i = command[0];
        int j = command[1];
        int k = command[2];
        
        int[] array = new int[j - i + 1];
        
        for (int idx = 0; idx + i - 1 < j; idx++) {
            array[idx] = numbers[idx + i - 1];
        }
        
        Arrays.sort(array);
        
        
        return array[k - 1];
    }
}