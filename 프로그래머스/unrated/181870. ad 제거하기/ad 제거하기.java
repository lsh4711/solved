class Solution {
    public String[] solution(String[] strArr) {
        int length = 0;
        boolean[] visits = new boolean[strArr.length];
        
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            int idx = str.indexOf("ad");
            if (idx == -1) {
                visits[i] = true;
                length++;
            }
        }
        
        int idx = 0;
        String[] result = new String[length];
        
        for (int i = 0; i < visits.length; i++) {
            boolean visit = visits[i];
            if (visit) {
                result[idx++] = strArr[i];
            }
        }
        
        return result;
    }
}