class Solution {
    public int solution(String[] board) {
        String[] OX = {"OOO", "XXX"};
        StringBuilder diaLeft = new StringBuilder();
        StringBuilder diaRight = new StringBuilder();
        int[] cnt = new int[89];
        boolean[] isWin = new boolean[89];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) cnt[board[i].charAt(j)]++;
            String rows = board[i];
            String cols = "" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i);
            diaLeft.append(board[i].charAt(i));
            diaRight.append(board[i].charAt(2 - i));
            if(rows.equals(OX[0]) || cols.equals(OX[0])) isWin['O'] = true;
            else if(rows.equals(OX[1]) || cols.equals(OX[1])) isWin['X'] = true;
        }
        if(diaLeft.toString().equals(OX[0]) || diaRight.toString().equals(OX[0])) isWin['O'] = true;
        else if(diaLeft.toString().equals(OX[1]) || diaRight.toString().equals(OX[1])) isWin['X'] = true;        
        
        if(cnt['O'] > cnt['X'] + 1 || cnt['O'] < cnt['X']) return 0;
        if(isWin['O'] && cnt['O'] == cnt['X'] || isWin['X'] && cnt['O'] != cnt['X']) return 0;
        return 1;
    }
}