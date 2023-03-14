import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(!visit[i][j] && maps[i].charAt(j) != 'X') answer.add(dfs(maps, visit, i, j));
            }
        }
        answer.sort(null);
        if(answer.size() == 0) answer.add(-1);
        
        return answer;
    }
    
    static int dfs(String[] maps, boolean[][] visit, int row, int col) {
        if(row<0 || col<0 || row>=visit.length || col>=visit[0].length || visit[row][col] || maps[row].charAt(col) == 'X') return 0;
        int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        visit[row][col] = true;
        int food = maps[row].charAt(col) - '0';
        for(int[] m : move) food += dfs(maps, visit, row+m[0], col+m[1]);
        
        return food;
    }
}