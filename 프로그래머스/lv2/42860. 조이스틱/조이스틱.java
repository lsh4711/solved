class Solution {
    public int solution(String name) {
        int dir = 0;
        int cnt = 0;
        int tmp = 0;
        int start = 0;
        int[] lineA = {0, 0, 0};
        char[] chars = name.toCharArray();
        
        for(int i = 0; i < name.length(); i++) {
            if(chars[i] == 'A') tmp++;
            else tmp = 0;
            if(lineA[2] < tmp) lineA = new int[] {i - tmp + 1, i, tmp};
        }
        if(lineA[0] <= 1) dir = -1;
        else if(lineA[1] == chars.length - 1) dir = 1;
        else if(lineA[0] > chars.length - lineA[1]) dir = -1;
        else dir = 1;
        while(true) {
            int interval = 0;
            char now = chars[start];
            cnt += Math.min(now - 65, 91 - now);
            chars[start] = 'A';
            tmp = start;
            while(start == tmp) {
                if(++interval == chars.length) return cnt;
                int left = (start + chars.length - interval) % chars.length;
                int right = (start + interval) % chars.length;
                if(dir <= 0 && chars[left] != 'A') start = left;
                else if(dir >= 0 && chars[right] != 'A') start = right;
            }
            cnt += interval;
            dir = 0;
        }
    }
}    