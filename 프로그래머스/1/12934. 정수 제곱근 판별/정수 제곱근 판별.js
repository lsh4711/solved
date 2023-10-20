function solution(n) {
    let num = parseInt(Math.sqrt(n));
    
    if (num * num === n) {
        num++;
        return num * num;
    }
    return -1;
}