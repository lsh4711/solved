class Solution {
    public int solution(int num, int k) {
        char[] arr = Integer.toString(num).toCharArray();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == k+'0') return i + 1;
        }
        
        return -1;
    }
}