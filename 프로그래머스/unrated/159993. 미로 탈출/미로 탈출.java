class Solution {
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        int distanceToLever = toDest(maps, new int[maps.length][maps[0].length()], start, 0, 'L');
        int distanceToEnd = toDest(maps, new int[maps.length][maps[0].length()], lever, 0, 'E');
        
        if (distanceToLever != (int)1e9 && distanceToEnd != (int)1e9) {
            return distanceToLever + distanceToEnd;
        }
        return -1;
    }
    
    static int toDest(String[] maps, int[][] distances, int[] now, int distance, char dest) {
        distances[now[0]][now[1]] = distance;
        if (distance == (int)1e9 || maps[now[0]].charAt(now[1]) == dest) {
            return distance;
        }
        int result = (int)1e9;
        
        for (int i = 0; i < 4; i++) {
            int[] move = moves[i];
            int[] next = {now[0] + move[0], now[1] + move[1]};
            if (next[0] < 0 || next[1] < 0 || next[0] >= maps.length || next[1] >= maps[0].length()
                    || distances[next[0]][next[1]] != 0 && distances[next[0]][next[1]] <= distance + 1
                    || maps[next[0]].charAt(next[1]) == 'X') {
                continue;
            }
            int distanceToDest = toDest(maps, distances, next, distance + 1, dest);
            if (result > distanceToDest) result = distanceToDest;
        }
        
        return result;
    }
}