class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int left = num_list[length - 2];
        int right = num_list[length - 1];
        int[] result = new int[length + 1];
        
        System.arraycopy(num_list, 0, result, 0, length);
        if (left < right) {
            result[length] = right - left;
        } else {
            result[length] = right * 2;
        }

        return result;
    }
}