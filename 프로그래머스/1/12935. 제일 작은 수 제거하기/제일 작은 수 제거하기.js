function solution(arr) {
    let min = Number.MAX_VALUE;
    let idx = 0;
    
    for (let i = 0; i < arr.length; i++) {
        const num = arr[i];
        if (num < min) {
            min = num;
            idx = i;
        }
    }
    arr.splice(idx, 1);
    
    if (!arr.length) {
        return [-1];
    }
    return arr;
}