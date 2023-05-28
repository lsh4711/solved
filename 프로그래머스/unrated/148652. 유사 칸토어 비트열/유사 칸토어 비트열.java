class Solution {
    public int solution(int n, long l, long r) {
        boolean isStartZero = false;
        boolean isEndZero = false;
        long[] oneCnts = new long[n + 1];
        long[][] ranges = new long[n + 1][];

        oneCnts[0] = 1;
        ranges[n] = new long[] {--l, --r};
        for (int i = n - 1; i >= 0; i--) {
            ranges[i] = new long[] {ranges[i + 1][0] / 5, ranges[i + 1][1] / 5};
        }

        for (int i = 1; i <= n; i++) {
            long beforeOneCnt = oneCnts[i - 1];
            long oneCnt = beforeOneCnt * 4;
            long[] range = ranges[i];
            long start = range[0] % 5;
            long end = range[1] % 5;

            if (!isStartZero) {
                if (start > 2) {
                    oneCnt++;
                }
                oneCnt -= start;
            }
            if (!isEndZero) {
                if (end < 2) {
                    oneCnt++;
                }
                oneCnt -= 4 - end;
            }
            if (start == 2) {
                isStartZero = true;
            }
            if (end == 2) {
                isEndZero = true;
            }
            oneCnts[i] = oneCnt;
        }

        return (int)oneCnts[n];
    }
}