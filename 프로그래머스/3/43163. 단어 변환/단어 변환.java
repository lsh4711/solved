class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visits = new boolean[words.length];
        int result = dfs(words, visits, begin, target, 0);
        
        if (result != 51) {
            return result;
        }
        return 0;
    }
    
    static int dfs(String[] words, boolean[] visits, String begin, String target, int cnt) {
        if (begin.equals(target)) {
            return cnt;
        }
        int result = 51;
        
        for (int i = 0; i < words.length; i++) {
            if (visits[i] || !canConvert(begin, words[i])) {
                continue;
            }
            visits[i] = true;
            int tmp = dfs(words, visits, words[i], target, cnt + 1);
            visits[i] = false;
            if (result > tmp) result = tmp;
        }
        
        return result;
    }
    
    static boolean canConvert(String str1, String str2) {
        boolean run = false;
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                continue;
            }
            if (run) {
                return false;
            }
            run = true;
        }
        
        return true;
    }
}