function solution(nums) {
    const max = parseInt(nums.length / 2);
    const array = [];
    let result = 0;
    
    for (const num of nums) {
        if (!array[num]) {
            result++;
            array[num] = true;
        }
    }
    
    return Math.min(result, max);
}