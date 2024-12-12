function solution(diffs, times, limit) {
    return binarySearch(diffs, times, limit);
}

const binarySearch = (diffs, times, limit) => {
    let start = 0;
    let end = 100_000;
    
    while (start < end) {
        const mid = Math.trunc((start + end) / 2);
        
        if (canAllPassInLimit(diffs, times, limit, mid)) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    
    return start || 1;
}

const canAllPassInLimit = (diffs, times, limit, level) => {
    let currentTime = BigInt(0);
    
    for (let i = 0; i < diffs.length; i++) {
        const diff = diffs[i];
        const time = BigInt(times[i]);
        
        if (diff <= level) {
            currentTime += time;
        } else {
            const repeat = BigInt(diff - level);
            const previousTime = i === 0 ? 0 : times[i - 1];
            currentTime += ((BigInt(previousTime) + time) * repeat) + time;
        }
        
        if (currentTime > limit) {
            return false;
        }
    }
    
    return true;
}