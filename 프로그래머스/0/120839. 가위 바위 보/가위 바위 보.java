class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        
        for (char num : rsp.toCharArray()) {
            if (num == '2') {
                sb.append(0);
            } else if (num == '0') {
                sb.append(5);
            } else {
                sb.append(2);
            }
        }
        
        return sb.toString();
    }
}