class Solution {
    public long solution(int[] weights) {
        long cnt = 0;
        int[] distincts = new int[1001];
        int[] multiples = new int[4001];

        for(int i = 0; i < weights.length; i++) {
            int now = weights[i];
            int distinct = distincts[now]++;
            cnt -= distinct * 3 - distinct;
            for(int j = 2; j <= 4; j++) {
                int multiple = now * j;
                if(multiples[multiple] != 0) cnt += multiples[multiple];
                multiples[multiple]++;
            }
        }
        
        return cnt;
    }
}