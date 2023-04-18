class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2];
        int[][] ascii = new int[90][2];
        char[] nswe = {'N', 'S', 'W', 'E'};
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for(int i = 0; i < 4; i++) ascii[nswe[i]] = moves[i];
        label : for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) != 'S') continue;
                start = new int[] {i, j};
                break label;
            }
        }
        
        label : for(String route : routes) {
            int[] move = ascii[route.charAt(0)];
            int distance = route.charAt(2) - 48;
            int row = start[0];
            int col = start[1];
            for(int i = 0; i < distance; i++) {
                int nextRow = row + move[0] ;
                int nextCol = col + move[1];
                if(nextRow < 0 || nextCol < 0 || nextRow >= park.length || nextCol >= park[0].length() || park[nextRow].charAt(nextCol) == 'X') continue label;
                row = nextRow;
                col = nextCol;
            }
            start = new int[] {row, col};
        }
        
        return start;
    }
}