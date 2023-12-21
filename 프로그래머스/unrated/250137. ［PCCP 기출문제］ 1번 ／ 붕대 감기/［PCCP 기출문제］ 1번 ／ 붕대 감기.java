class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int now = 0;
        
        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int attackDamage = attack[1];
            
            int recoveryTime = attackTime - now;
            int recoveryAmount = calculateRecoveryAmount(maxHealth, bandage, recoveryTime - 1);
            health = Math.min(health + recoveryAmount, maxHealth);
            health -= attackDamage;
            System.out.println(health);
            if (health <= 0) {
                return -1;
            }
            now = attackTime;
        }
        
        return health;
    }
    
    private int calculateRecoveryAmount(int maxHealth, int[] bandage, int seconds) {
        if (seconds <= 0) {
            return 0;
        }
        
        int recoveryAmount = 0;
        
        while (seconds > 0) {
            if (seconds >= bandage[0]) {
                recoveryAmount += bandage[0] * bandage[1] + bandage[2];
                seconds -= bandage[0];
            } else {
                recoveryAmount += bandage[1] * seconds;
                seconds = 0;
            }
        }
        
        return recoveryAmount;
    }
}