class Solution {
    public String solution(int[] numLog) {
        int before = numLog[0];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < numLog.length; i++) {
            int num = numLog[i];
            int result = num - before;
            before = num;
            if (result == 1) {
                sb.append('w');
            } else if (result == -1) {
                sb.append('s');
            } else if (result == 10) {
                sb.append('d');
            } else {
                sb.append('a');
            }
        }
        
        return sb.toString();
    }
}