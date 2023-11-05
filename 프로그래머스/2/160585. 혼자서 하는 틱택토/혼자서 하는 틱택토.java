class Solution {
    public int solution(String[] board) {
        int[] cnt = new int[89];
        boolean[] isWin = new boolean[89];
        
        for(int i = 0; i < 3; i++) {
            int[] line = new int[4];
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'O') line[0]++;
                else if(board[i].charAt(j) == 'X') line[0]--;
                if(board[j].charAt(i) == 'O') line[1]++;
                else if(board[j].charAt(i) == 'X') line[1]--;
                if(board[j].charAt(j) == 'O') line[2]++;
                else if(board[j].charAt(j) == 'X') line[2]--;
                if(board[j].charAt(2 - j) == 'O') line[3]++;
                else if(board[j].charAt(2 - j) == 'X') line[3]--;
                cnt[board[i].charAt(j)]++;
            }
            if(line[0] == 3 || line[1] == 3 || line[2] == 3 || line[3] == 3) isWin['O'] = true;
            else if(line[0] == -3 || line[1] == -3 || line[2] == -3 || line[3] == -3) isWin['X'] = true;
        }
        
        if(cnt['O'] > cnt['X'] + 1 || cnt['O'] < cnt['X']) return 0;
        if(isWin['O'] && cnt['O'] == cnt['X'] || isWin['X'] && cnt['O'] != cnt['X']) return 0;
        return 1;
    }
}