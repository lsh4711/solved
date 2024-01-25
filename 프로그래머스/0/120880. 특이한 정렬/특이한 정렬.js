function solution(numlist, n) {
    return numlist.sort((n1, n2) => {
        const abs1 = Math.abs(n - n1);
        const abs2 = Math.abs(n - n2);
        
        if (abs1 !== abs2) {
            return abs1 - abs2;
        }
        return n2 - n1;
    });
}