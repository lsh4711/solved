class Solution {
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            int[] depth = triangle[i];
            for (int j = 0; j < depth.length; j++) {
                int left = triangle[i + 1][j];
                int right = triangle[i + 1][j + 1];
                depth[j] += Math.max(left, right);
            }
        }
        
        return triangle[0][0];
    }
}