class Solution {
    public int solution(String[] board) {
        String O = "OOO";
        String X = "XXX";
        String diaLeft = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        String diaRight = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);
        int[] cnt = new int[89];
        boolean[] isWin = new boolean[89];
        
        for(String line : board) {
            for(int i = 0; i < 3; i++) cnt[line.charAt(i)]++;
        }
        for(int i = 0; i < 3; i++) {
            String rows = board[i];
            String cols = "" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i);
            if(rows.equals(O) || rows.equals(X)) isWin[rows.charAt(0)] = true;
            if(cols.equals(O) || cols.equals(X)) isWin[cols.charAt(0)] = true;
        }
        if(diaLeft.equals(O) || diaLeft.equals(X)) isWin[diaLeft.charAt(0)] = true;
        if(diaRight.equals(O) || diaRight.equals(X)) isWin[diaRight.charAt(0)] = true;        
        
        if(cnt['O'] > cnt['X'] + 1 || cnt['O'] < cnt['X']) return 0;
        if(isWin['O'] && cnt['O'] == cnt['X'] || isWin['X'] && cnt['O'] != cnt['X']) return 0;
        return 1;
    }
}