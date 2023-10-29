function solution(cards1, cards2, goal) {
    let idx1 = 0;
    let idx2 = 0;
    let goalIdx = 0;
    
    for (word of goal) {
        const word1 = cards1[idx1];
        const word2 = cards2[idx2];
        if (idx1 < cards1.length && word1 == word) {
            idx1++;
            continue;
        }
        if (idx2 < cards2.length && word2 == word) {
            idx2++;
            continue;
        }
        return "No";
    }
    
    return "Yes";
}
