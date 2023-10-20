function solution(n) {
    const result = [];
    
    while(n > 0) {
        result.push(n % 10);
        n = parseInt(n / 10);
    }
    
    return result;
}