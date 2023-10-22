function solution(park, routes) {
    const directionMap = getInitializedDirectionMap();
    const start = findStartCoor(park);
    
    for (const route of routes) {
        moveDog(park, route, directionMap, start);
    }
    
    return start;
}


const getInitializedDirectionMap = () => {
    const directions = ['N', 'S', 'W', 'E'];
    const moves = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    const directionMap = new Map();
    
    for (const idx in directions) {
        directionMap.set(directions[idx], moves[idx]);
    }

    return directionMap;
}

const findStartCoor = (park) => {
    for (let i = 0; i < park.length; i++) {
        for (let j = 0; j < park.length; j++) {
            const now = park[i].charAt(j);
            if (now === "S") {
                return [i, j];
            }
        }
    }

}

const moveDog = (park, route, directionMap, start) => {
    const move = directionMap.get(route.charAt(0));
    let distance = route.charAt(2);
    let nextRow = start[0];
    let nextCol = start[1];
    
    while (distance-- > 0) {
        nextRow += move[0];
        nextCol += move[1];
        if (!isInRange(park, nextRow, nextCol) || park[nextRow][nextCol] === 'X') {
            return;
        }
    }
    start[0] = nextRow;
    start[1] = nextCol;
}

const isInRange = (park, row, col) => {
    if (row >= 0 && col >= 0 && row < park.length && col < park[0].length) {
        return true;
    }
    return false;
}