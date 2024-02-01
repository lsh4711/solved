class Solution {
    private int result;
    private int seconds;
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        seconds = 3600 * h1 + 60 * m1 + s1;
        int end = 3600 * h2 + 60 * m2 + s2;
        
        check();
        while (seconds < end) {
            move();
        }
        
        return result;
    }
    
    private void check() {
        double angleH = seconds % (3600 * 12) / 120.0;
        double angleM = seconds % 3600 * 0.1;
        int angleS = seconds % 60 * 6;
        
        if (angleH == angleS || angleM == angleS) {
            result++;
        }
        
    }
    
    private void move() {
        int angleS = seconds % 60 * 6;
        double angleH = (seconds % (3600 * 12)) / 120.0;
        double angleM = (seconds % 3600) * 0.1;
        
        seconds++;
        
        int nextAngleS = (seconds) % 60 * 6;
        double nextAngleH = (seconds % (3600 * 12)) / 120.0;
        double nextAngleM = (seconds % 3600) * 0.1;
        
        boolean isSamePointWithSeconds = false;
        int cnt = 0;
        
        if (nextAngleS != 0) {
            if (angleS < angleH && nextAngleH <= nextAngleS) {
                if (nextAngleH == nextAngleS) {
                    isSamePointWithSeconds = true;
                }
                cnt++;
            }
            if (angleS < angleM && nextAngleM <= nextAngleS) {
                if (!isSamePointWithSeconds || nextAngleM != nextAngleS) {
                    cnt++;
                }
            }
        } else {
            if (angleS < angleH) {
                if (nextAngleH == nextAngleS) {
                    isSamePointWithSeconds = true;
                }
                cnt++;
            }
            if (angleS < angleM) {
                if (!isSamePointWithSeconds || nextAngleM != nextAngleS) {
                    cnt++;
                }
            }
        }
        result += cnt;
    }
}