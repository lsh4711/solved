class Solution {
    public int solution(int[] num_list) {
        if (num_list.length >= 11) {
            return getSum(num_list);
        }
        return getProduct(num_list);
    }
    
    private int getSum(int[] num_list) {
        int sum = 0;
        
        for (int num : num_list) {
            sum += num;
        }
        
        return sum;
    }
    
    private int getProduct(int[] num_list) {
        int product = 1;
        
        for (int num : num_list) {
            product *= num;
        }
        
        return product;
    }
}