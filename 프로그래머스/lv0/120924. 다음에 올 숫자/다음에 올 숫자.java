class Solution {
    public int solution(int[] common) {
        int subtract = common[1] - common[0];
        if(subtract == common[2] - common[1]) return common[common.length - 1] + subtract;
        return common[1] / common[0] * common[common.length - 1];
    }
}