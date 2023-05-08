class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2]; // 강아지 시작 좌표
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 북, 남, 서, 동으로 한칸씩 이동
        
        // 시작 좌표 구함
        label: for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) != 'S') continue;
                start = new int[] {i, j};
                break label;
            }
        }
        
        // 명령(routes) 순차적으로 실행
        label: for(String route : routes) {
            int idx = -1; // move의 인덱스 역할
            
            if(route.charAt(0) == 'N') idx = 0; // 방향에 따른 move배열 인덱스 설정(리팩토링 가능)
            else if(route.charAt(0) == 'S') idx = 1;
            else if(route.charAt(0) == 'W') idx = 2;
            else if(route.charAt(0) == 'E') idx = 3;
            int row = start[0];
            int col = start[1];
            for(int i = 0; i < route.charAt(2) - '0'; i++) {
                row += move[idx][0];
                col += move[idx][1];
                if(row < 0 || col < 0 || row >= park.length || col >= park[0].length()) continue label;
                if(park[row].charAt(col) == 'X') continue label;
            }
            start[0] = row;
            start[1] = col;
        }
        
        return start;
    }
}