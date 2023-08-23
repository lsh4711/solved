class Solution {
    public int solution(int[] num_list) {
        int[] sumArr = new int[2];
        
        for (int i = 0; i < num_list.length; i++) {
            int r = i % 2;
            int num = num_list[i];
            sumArr[r] += num;
        }
        
        if (sumArr[0] > sumArr[1]) {
            return sumArr[0];
        }
        return sumArr[1];
    }
}