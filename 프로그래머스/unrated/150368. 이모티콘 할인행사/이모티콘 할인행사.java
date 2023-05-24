class Solution {
    static int[] result = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(users, emoticons, new int[emoticons.length][2], 0);
        
        return result;
    }
    
    static void dfs(int[][] users, int[] emoticons, int[][] prices, int idx) {
        if (prices.length == idx) {
            check(users, prices);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int discntRate = (i + 1) * 10;
            int price = emoticons[idx] * (9 - i) / 10;
            prices[idx][0] = discntRate;
            prices[idx][1] = price;
            dfs(users, emoticons, prices, idx + 1);
        }
        
    }
    
    static void check(int[][] users, int[][] prices) {
        int plus = 0;
        int income = 0;
        
        for (int i = 0; i < users.length; i++) {
            int total = 0;
            int expected  = users[i][0];
            for (int j = 0; j < prices.length; j++) {
                int actual  = prices[j][0];
                int price = prices[j][1];
                if (expected <= actual) {
                    total += price;
                }
            }
            if (users[i][1] <= total) {
                plus++;
            } else {
                income += total;
            }
        }
        if (result[0] < plus) {
                result[0] = plus;
                result[1] = income;
        } else if (result[0] == plus && result[1] < income) {
            result[1] = income;
        }
        
    }
} 