function solution(num_list, n) {
    const result = [];
    
    while (n++ <= num_list.length) {
        result.push(num_list[n - 2]);
    }
    
    return result;
}