function solution(progresses, speeds) {
    const result = [];
    let cnt = 0;
    let day = 0;
    let idx = 0;
    
    while (idx < progresses.length) {
        const speed = speeds[idx];
        const progress = progresses[idx] + (speed * day);
        
        if (progress >= 100) {
            cnt++;
            idx++;
            continue;
        }
        
        if (cnt > 0) {
            result.push(cnt);
            cnt = 0;
        }
        
        day += Math.ceil((100 - progress) / speed);
    }
    
    result.push(cnt);
    
    return result;
}