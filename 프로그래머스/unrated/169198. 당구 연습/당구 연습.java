class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) answer[i] = cushion(balls[i], m, n, startX, startY);
        
        return answer;
    }
    
    static int cushion(int[] ball, int m, int n, int startX, int startY) {
        int result = (int)5e6;
        int[][] dirs = {{startX - ball[0], n - startY, n - ball[1]},
                {startX - ball[0], startY, ball[1]},
                {startY - ball[1], startX, ball[0]},
                {startY - ball[1], m - startX, m - ball[0]}};
        
        for(int i = 0; i < 4; i++) {
            int[] dir = dirs[i];
            if(dir[0] == 0 && dir[1] > dir[2]) continue;
            int length = (int)(Math.pow(dir[0], 2) + Math.pow(dir[1] + dir[2], 2));
            if(result > length) result = length;
        }
        
        return result;
    }
} 