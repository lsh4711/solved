function solution(start_num, end_num) {
    const result = [];
    
    while (start_num <= end_num) {
        result.push(start_num);
        start_num++;
    }
    
    return result;
}