function solution(x, n) {
    const answer = [];
    
    for (let i = x; n-- > 0; i += x) {
        answer.push(i);
    }
    
    return answer;
}