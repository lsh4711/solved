const isPrimes = initPrimes(9999999);
const set = new Set();

function solution(numbers) {
    let result = 0;
    
    dfs(numbers.split(""), "");
    set.forEach(num => {
        if (num >= 2) {
            result += isPrimes[num] ? 1 : 0;
        }
    });
    
    return result;
}

function initPrimes(max) {
    const isPrimes = Array.from({length: max}, () => true);
    
    for (let i = 2; i <= max; i++) {
        for (let j = 2; j <= max; j++) {
            const multi = i * j;
            if (multi > max) {
                break;
            }
            isPrimes[multi] = false;
        }    
    }
    
    return isPrimes;
}

const dfs = (numbers, currentNumber) => {
    set.add(parseInt(currentNumber));
    
    if (numbers.length === currentNumber.length) {
        return;
    }
    
    for (let i = 0; i < numbers.length; i++) {
        const number = numbers[i];
        if (number === "") {
            continue;
        }
        const temp = number;
        numbers[i] = "";
        dfs(numbers, currentNumber + number)
        numbers[i] = temp;
    }
    
}
