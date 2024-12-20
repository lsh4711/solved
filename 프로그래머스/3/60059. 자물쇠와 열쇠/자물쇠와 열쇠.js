function solution(key, lock) {
    const holeString = analyzeLock(lock);
    let currentKey = null;
    
    for (let i = 0; i < 4; i++) {
        currentKey = currentKey ? rotate(currentKey) : key;
        if (tryOpen(currentKey, lock, holeString)) {
            return true;
        }
    }

    return false;
}

const analyzeLock = (lock) => {
    const holes = [];
    
    lock.forEach((row, rowIdx) => {
        row.forEach((col, colIdx) => {
            if (col !== 0) {
                return;
            }
            holes.push([rowIdx, colIdx]);
        });
    });
    
    return holes.toString();
}

const analyzeKey = (key) => {
    const blocks = [];
    
    key.forEach((row, rowIdx) => {
        row.forEach((col, colIdx) => {
            if (col !== 1) {
                return;
            }
            blocks.push([rowIdx, colIdx]);
        });
    });
    
    return blocks;
}

const rotate = (square) => {
    const length = square.length;
    const newSquare = Array.from({length}, () => new Array(length).fill());
    
    square.forEach((row, rowIdx) => {
        row.forEach((col, colIdx) => newSquare[colIdx][length - rowIdx - 1] = col);
    })
    
    return newSquare;
}

const tryOpen = (key, lock, holeString) => {
    const keyRowLength = key.length
    const keyColLength = key[0].length;
    const lockRowLength = lock.length
    const lockColLength = lock[0].length;
    const keyBlocks = analyzeKey(key);
    
    for (let rowOffset = -keyRowLength + 1; rowOffset < lockRowLength; rowOffset++) {
        for (let colOffset = -keyColLength + 1; colOffset < lockColLength; colOffset++) {
            const blocks = [];
            keyBlocks.forEach(keyBlock => {
                const row = keyBlock[0] + rowOffset;
                const col = keyBlock[1] + colOffset;
                if (row < 0 || col < 0 || row >= lock.length || col >= lock[row].length) {
                    return;
                }
                blocks.push([row, col]);
            });
            if (blocks.toString() === holeString) {
                return true;
            }
        }
    }
    
    return false;
}
