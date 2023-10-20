function solution(arr) {
    let result = 0;
    
    for (i of arr) {
        result += i;
    }
    
    return result / arr.length;
}