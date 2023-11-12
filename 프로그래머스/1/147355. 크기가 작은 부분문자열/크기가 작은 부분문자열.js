function solution(t, p) {
    let result = 0;
    const pNum = parseInt(p);
    
    for (let start = 0; start <= t.length - p.length; start++) {
        const end = start + p.length;
        const num = stringToNumber(t.substring(start, end));
        if (num <= pNum) {
            result++;
        }
    }
    
    return result;
}

const stringToNumber = (string) => {
    return parseInt(string);
}