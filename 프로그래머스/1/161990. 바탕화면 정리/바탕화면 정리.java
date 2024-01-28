class Solution {
    public int[] solution(String[] wallpaper) {
        int[] result = {49, 49, 1, 1};
        
        for (int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];
            for (int j = 0; j < line.length(); j++) {
                char point = line.charAt(j);
                if (point == '.') {
                    continue;
                }
                updateResult(result, i, j);
            }
        }
        
        return result;
    }
    
    private void updateResult(int[] result, int row, int col) {
        if (result[0] > row) {
            result[0] = row;
        }
        if (result[1] > col) {
            result[1] = col;
        }
        if (result[2] - 1 < row) {
            result[2] = row + 1;
        }
        if (result[3] - 1 < col) {
            result[3] = col + 1;
        }
        
    }
}