import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Integer[] boxedNumbers = new Integer[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            boxedNumbers[i] = numbers[i];
        }
        
        Arrays.sort(boxedNumbers, (num1, num2) -> {
            char[] nums1 = num1.toString().toCharArray();
            char[] nums2 = num2.toString().toCharArray();
            int length = Math.max(nums1.length, nums2.length);
            for (int i = 0; i < length * 2; i++) {
                int nums1Idx = i % nums1.length;
                int nums2Idx = i % nums2.length;
                if (nums1[nums1Idx] == nums2[nums2Idx]) {
                    continue;
                }
                return nums2[nums2Idx] - nums1[nums1Idx];
            }
            return 0;
        });
        
        for (int number : boxedNumbers) {
            if (sb.length() == 0 && number == 0) {
                continue;
            }
            sb.append(number);
        }
        
        return sb.length() == 0
            ? "0"
            : sb.toString();
    }
}