function solution(n) {
    let sqrt = Math.sqrt(n);
    
    if (Number.isInteger(sqrt)) {
        sqrt++;
        return sqrt * sqrt;
    }
    return -1;
}