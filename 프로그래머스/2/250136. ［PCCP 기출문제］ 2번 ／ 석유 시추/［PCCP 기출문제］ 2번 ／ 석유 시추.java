class Solution {
    private int[] line;
    private int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(int[][] land) {
        line = new int[land[0].length];
        
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                if (!isOil(land, row, col)) {
                    continue;
                }
                boolean[] visit = new boolean[line.length];
                int amount = dfs(land, visit, row, col);
                updateCumulativeAmount(visit, amount);
            }
        }
        
        return getMaxAmount();
    }
    
    private boolean isOil(int[][] land, int row, int col) {
        return 0 <= row && row < land.length
            && 0 <= col && col < land[0].length
            && land[row][col] == 1;    
    }
    
    private int dfs(int[][] land, boolean[] visit, int row, int col) {
        if (!isOil(land, row, col)) {
            return 0;
        }
        
        int amount = 1;
        land[row][col] = 0;
        visit[col] = true;
        
        for (int[] move : moves) {
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            amount += dfs(land, visit, nextRow, nextCol);
        }
        
        return amount;
    }
    
    private void updateCumulativeAmount(boolean[] visit, int amount) {
        for (int idx = 0; idx < visit.length; idx++) {
            if (visit[idx]) {
                line[idx] += amount;
            }
        }
        
    }
    
    private int getMaxAmount() {
        int maxAmount = 0;
        
        for (int amount : line) {
            if (amount > maxAmount) {
                maxAmount = amount;
            }
        }
        
        return maxAmount;
    }
}