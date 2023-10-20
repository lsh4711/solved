function solution(n) {
    n--;
    for (let i = 2; true; i++) {
        if (n % i === 0) {
            return i;
        }
    }
         
}