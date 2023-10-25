function solution(n, m, section) {
    let idx = 0;
    let now = 0;
    let result = 0;
    
    while (idx < section.length) {
        const target = section[idx];
        if (now <= target) {
            result++;
            now = target + m;
        } else {
            idx++;
        }
    }
    
    return result;
}