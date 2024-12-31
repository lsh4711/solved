const fs = require('fs');
const input = fs.readFileSync('/dev/stdin', 'utf8')
    .split('\n')
    .map(line => line.split(' ').map(string => parseInt(string)));
const [[_size, maxWeight], ...objects] = input;
const dp = new Array(maxWeight + 1).fill(0);

for (const [weight, worth] of objects) {
    for (let i = maxWeight; i >= weight; i--) {
        dp[i] = Math.max(dp[i - weight] + worth, dp[i]);
    }
}

console.log(dp[maxWeight]);