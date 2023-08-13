class Solution {
    public String solution(String a, String b) {
        int tmp = 0;
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        
        while (aIdx >= 0 || bIdx >= 0 || tmp > 0) {
            int aNum = aIdx >= 0 ? a.charAt(aIdx--) - '0' : 0;
            int bNum = bIdx >= 0 ? b.charAt(bIdx--) - '0' : 0;
            tmp += aNum + bNum;
            int remain = tmp % 10;
            sb.append(remain);
            tmp /= 10;
        }
        
        return sb.reverse().toString();
    }
}