class Solution {
    public int solution(int[] common) {
        int end = common[common.length-1];
        if(common[1]*2 == common[0]+common[2]) return end+ common[1] - common[0];
        return end * common[1] / common[0];
    }
}
