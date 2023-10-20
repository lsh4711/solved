function solution(s){
    let pCnt = 0;
    let yCnt = 0;
    
    for (str of s.split("")) {
        str = str.toUpperCase();
        if (str === "P") {
            pCnt++;
        } else if (str === "Y") {
            yCnt++;
        }
    }
    
    return pCnt === yCnt;
}