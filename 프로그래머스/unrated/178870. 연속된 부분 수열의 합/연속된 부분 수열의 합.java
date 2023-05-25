class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = sequence.length - 1;
        int end = sequence.length - 1;
        int sum = sequence[end];
        
        while (true) {
            if (sum < k) {
                start--;
                sum += sequence[start];
            } else if (sum > k) {
                sum -= sequence[end];
                end--;
            } else {
                if (sequence[start] != sequence[end] || start == 0 || sequence[start - 1] != sequence[start]) {
                    return new int[] {start, end};
                }
                start--;
                end--;
            }
        }
        
    }
}