function solution(n, money) {
    const memory = new Array(n + 1).fill(0);
    memory[0] = 1;
    
    money.forEach(m => {
        for (let i = 1; i <= n; i++) {
            if (i < m) {
                continue;
            }
            memory[i] += memory[i - m];
        }
    });

    return memory[n];
}

const dp = (coin, money) => {
    if (coin < 0) {
        return 0;
    }
    
    if (coin === 0) {
        return 1;
    }
    
    memory[coin] += dp(coin - money, money);
    
    return memory[coin];
}
