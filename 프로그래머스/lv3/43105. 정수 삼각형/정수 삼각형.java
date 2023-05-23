class Solution {
    public int solution(int[][] triangle) {
//         [dfs]
//         dfs로 안되는 이유: 
//         왜 안되는지 바로 이해가 안되서 직접 세보니 
//         같은 노드를 여러번 방문한다..
        
//         [dp: bottom-up],
//         위에서 아래 방향으로도 구현이 가능하지만 
//         왼쪽 부모와 오른쪽 부모 노드가 존재하는지 검증(if문 2개) 필요
//         아래에서 위 방향으로 올라가는 경우는 자식노드는 반드시 2개이므로 검증 no필요
        
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