class Solution {
    private int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        for (int[] move : moves) {
            int targetH = h + move[0];
            int targetW = w + move[1];
            if (isInRange(targetH, targetW, board.length) && color.equals(board[targetH][targetW])) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isInRange(int h, int w, int length) {
        return h >= 0 && w >= 0 && h < length && w < length;
    }
}