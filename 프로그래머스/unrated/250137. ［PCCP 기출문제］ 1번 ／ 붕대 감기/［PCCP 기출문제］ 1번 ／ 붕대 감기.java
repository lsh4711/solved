class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int now = 0;
        
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int attackDamage = attack[1];
            int recoveryTime = attackTime - now - 1;
            
            if (recoveryTime > 0) {
                int recoveryAmount = calculateRecoveryAmount(maxHealth, bandage, recoveryTime);
                health = Math.min(health + recoveryAmount, maxHealth);
            }
            health -= attackDamage;
            if (health <= 0) {
                return -1;
            }
            now = attackTime;
        }
        
        return health;
    }
    
    private int calculateRecoveryAmount(int maxHealth, int[] bandage, int seconds) {
        int recoveryAmount = seconds * bandage[1];
        int extraRecoveryAmount = seconds / bandage[0] * bandage[2];
        
        return recoveryAmount + extraRecoveryAmount;
    }
}