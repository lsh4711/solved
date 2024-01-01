function solution(t, p) {
    let result = 0;
    let start = 0;
    let end = p.length;
    
    while (end <= t.length) {
        const string = t.substring(start, end);
        
        if (isExpectedValue(string, p)) {
            result++;
        }
        start++;
        end++;
    }
    
    return result;
}

const isExpectedValue = (string, p) => {
    return string <= p;
}