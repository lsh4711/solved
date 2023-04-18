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
            int startRow = start[0];
            int startCol = start[1];
            for(int i = 0; i < distance; i++) {
                int row = startRow + move[0] ;
                int col = startCol + move[1];
                if(row < 0 || col < 0 || row >= park.length || col >= park[0].length() || park[row].charAt(col) == 'X') continue label;
                startRow = row;
                startCol = col;
            }
            start = new int[] {startRow, startCol};
        }
        
        return start;
    }
}