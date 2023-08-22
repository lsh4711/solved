class Solution {
    public int[] solution(String myString) {
        String[] split = myString.split("x", -1);
        int[] result = new int[split.length];
        
        for (int i = 0; i < split.length; i++) {
            result[i] = split[i].length();
        }
        
        return result;
    }
}