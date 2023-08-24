class Solution {
    public int solution(int[] num_list) {
        int result = 0;
        int powerOfTen1 = 1;
        int powerOfTen2 = 1;
        
        for (int i = num_list.length - 1; i >= 0; i--) {
            int num = num_list[i];
            if (num % 2 == 1) {
                result += num * powerOfTen1;
                powerOfTen1 *= 10;
            } else {
                result += num * powerOfTen2;
                powerOfTen2 *= 10;
            }
        }
        
        return result;
    }
}