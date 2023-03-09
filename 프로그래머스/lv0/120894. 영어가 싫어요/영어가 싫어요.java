class Solution {
    public long solution(String numbers) {
        String[] strarr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<strarr.length; i++) numbers = numbers.replace(strarr[i], Integer.toString(i));
        
        return Long.parseLong(numbers);
    }
}
     