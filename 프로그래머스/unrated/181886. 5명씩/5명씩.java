class Solution {
    public String[] solution(String[] names) {
        int length = (names.length + 4) / 5;
        String[] result = new String[length];
        
        for (int i = 0; i < length; i++) {
            result[i] = names[i * 5];
        }
        
        return result;
    }
}