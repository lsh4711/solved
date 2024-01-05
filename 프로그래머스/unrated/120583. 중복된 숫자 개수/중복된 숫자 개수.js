function solution(array, n) {
    let result = 0;
    
    for (const num of array) {
        if (n === num) {
            result++;
        }
    }
    
    return result;
}