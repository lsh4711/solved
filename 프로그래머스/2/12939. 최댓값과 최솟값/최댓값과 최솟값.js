function solution(s) {
    let min = Number.MAX_SAFE_INTEGER;
    let max = Number.MIN_SAFE_INTEGER;
    
    for (const numString of s.split(" ")) {
        const num = parseInt(numString);
        
        if (num < min) {
            min = num
        }
        if (num > max) {
            max = num;
        }
    }
    
    return `${min} ${max}`;
}