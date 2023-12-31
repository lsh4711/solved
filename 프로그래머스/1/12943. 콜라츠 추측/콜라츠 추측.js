function solution(num) {
    let result = 0;
    
    while (num != 1) {
        if (result++ > 500) {
            return -1;
        }
        if (num % 2 == 0) {
            num /= 2;
        } else {
            num = num * 3 + 1;
        }
    }
    
    return result;
}