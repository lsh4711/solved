class Solution {
    public int[] solution(String[] strlist) {
        int[] result = new int[strlist.length];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = strlist[i].length();
        }
        
        return result;
    }
}