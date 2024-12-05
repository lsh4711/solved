function solution(nums) {
    const length = Math.trunc(nums.length / 2);
    const set = new Set(nums);
    
    return Math.min(length, set.size);
}