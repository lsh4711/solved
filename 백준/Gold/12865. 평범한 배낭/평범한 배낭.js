const fs = require('fs');
const input = fs.readFileSync('/dev/stdin', 'utf8')
    .split('\n')
    .map(line => line.split(' ').map(string => parseInt(string)));
const [[size, maxWeight], ...objects] = input;
const dp = new Array(maxWeight + 1).fill(0);

for (const [weight, worth] of objects) {
    for (let j = maxWeight; j >= weight; j--) {
        dp[j] = Math.max(dp[j], dp[j - weight] + worth);
    }
}

console.log(dp[maxWeight]);