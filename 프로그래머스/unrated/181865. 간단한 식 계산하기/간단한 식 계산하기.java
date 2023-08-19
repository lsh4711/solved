class Solution {
    public int solution(String binomial) {
        int result = 0;
        String[] split = binomial.split(" ");
        int a = Integer.parseInt(split[0]);
        int op = split[1].charAt(0);
        int b = Integer.parseInt(split[2]);
        
        if (op == '+') {
            result = a + b;
        } else if (op == '-') {
            result = a - b;
        } else {
            result = a * b;
        }
        
        return result;
    }
}