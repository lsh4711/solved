class Solution {
    public int solution(int[] cards) {
        int first = 0;
        int[] groupCnt = new int[101];

        for(int i = 0; i < cards.length; i++) {
            if(cards[i] == 0) continue;
            int cnt = 0;
            for(int idx = i; cards[idx] != 0; cnt++) {
                int temp = cards[idx] - 1;
                cards[idx] = 0;
                idx = temp;
            }
            groupCnt[cnt]++;
        }

        if(groupCnt[cards.length] != 0) return 0;
        for(int i = groupCnt.length - 2; true; i--) {
            if(groupCnt[i] == 0) continue;
            if(first == 0) first = i;
            else return first * i;
            if(groupCnt[i] == 2) return first * i;
        }
    }
} 