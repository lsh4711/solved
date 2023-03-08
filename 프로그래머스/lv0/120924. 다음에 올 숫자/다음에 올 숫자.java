class Solution {
    public int solution(int[] common) {
        int length = common[common.length-1];
        if(common[0]+common[2] == common[1]*2) return length + common[1] - common[0];
        return length * common[1]/common[0];
    }
}
