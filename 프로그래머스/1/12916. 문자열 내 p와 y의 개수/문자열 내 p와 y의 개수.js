function solution(s){
    const asciis = Array.from({length: 90}, () => 0);
    
    for (str of s.split("")) {
        let idx = str.charCodeAt();
        if (idx >= 97) {
            idx -= 32;
        }
        asciis[idx]++;
    }
    
    const pCnt = asciis['P'.charCodeAt()];
    const yCnt = asciis['Y'.charCodeAt()];
    
    return pCnt === yCnt;
}