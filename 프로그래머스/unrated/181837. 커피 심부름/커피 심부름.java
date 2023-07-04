class Solution {
    public int solution(String[] order) {
        int money = 0;
        
        for (String menu : order) {
            if (menu.contains("cafelatte")) {
                money += 5000;
            } else {
                money += 4500;
            }
        }
        
        return money;
    }
}