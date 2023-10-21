function solution(names, scores, photos) {
    const result = [];
    const map = new Map();
    
    initScore(map, names, scores);
    for (photo of photos) {
        result.push(calculateTotalScore(map, photo));
    }
    
    return result;
}

const initScore = (map, names, scores) => {
    for (let i = 0; i < names.length; i++) {
        const name = names[i];
        const score = scores[i];
        map.set(name, score);
    }
    
}

const calculateTotalScore = (map, photo) => {
    let totalScore = 0;
    
    for (const name of photo) {
        const score = map.get(name);
        if (score) {
            totalScore += score;
        }
    }
    
    return totalScore;
}