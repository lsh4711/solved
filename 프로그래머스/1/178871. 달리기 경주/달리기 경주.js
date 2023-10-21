function solution(players, callings) {
    const map = new Map();
    
    for (i = 0; i < players.length; i++) {
        const player = players[i];
        map.set(player, i);
    }
    for (calling of callings) {
        const playerIdx = map.get(calling);
        const targetPlayerIdx = playerIdx - 1;
        map.set(calling, targetPlayerIdx);
        map.set(players[targetPlayerIdx], playerIdx);
        swapRanking(players, playerIdx, targetPlayerIdx);
    }
    
    return players;
}

const swapRanking = (players, playerIdx, targetPlayerIdx) => {
    const tmp = players[playerIdx];
    players[playerIdx] = players[targetPlayerIdx];
    players[targetPlayerIdx] = tmp;
}