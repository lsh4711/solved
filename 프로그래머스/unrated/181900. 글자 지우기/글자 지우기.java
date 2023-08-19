class Solution {
    public String solution(String my_string, int[] indices) {
        boolean[] visits = new boolean[my_string.length()];
        StringBuilder sb = new StringBuilder();
        
        for (int indice : indices) {
            visits[indice] = true;
        }
        for (int i = 0; i < my_string.length(); i++) {
            if (!visits[i]) {
                char now = my_string.charAt(i);
                sb.append(now);
            }
        }
        
        return sb.toString();
    }
}