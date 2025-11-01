function solution(nums) {
    const set = new Set();
    
    nums.forEach(num => set.add(num));
    
    const size = Math.floor(nums.length / 2);
    
    return Math.min(size, set.size);
}