function solution(participant, completion) {
    const map = new Map();
    
    participant.forEach(runner => {
        const value = (map.get(runner) || 0) + 1;
        map.set(runner, value);
    });
    completion.forEach(runner => {
        const value = map.get(runner) - 1;
        map.set(runner, value);
    });
    
    for (const [runner, value] of map.entries()) {
        if (value > 0) {
            return runner;
        }
    }
    
    return 5;
}