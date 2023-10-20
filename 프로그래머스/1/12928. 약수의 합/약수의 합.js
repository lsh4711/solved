function solution(n) {
    let result = 0;
    
    for (let i = 1; i * i <= n; i++) {
        if (n % i === 0) {
            if (i * i === n) {
                result -= i;
            }
            result += i + n / i;
        }
    }
    
    return result;
}