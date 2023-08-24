class Solution {
    public String[] solution(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (i % 2 == 1) {
                strArr[i] = str.toUpperCase();
            } else {
                strArr[i] = str.toLowerCase();
            }
        }

        return strArr;
    }
}