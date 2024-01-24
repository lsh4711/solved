function solution(a, b) {
    while (b % 2 === 0) {
        b /= 2;
    }
    while (b % 5 === 0) {
        b /= 5;
    }
    
    if (a % b === 0) {
        return 1;
    }
    return 2;
}
