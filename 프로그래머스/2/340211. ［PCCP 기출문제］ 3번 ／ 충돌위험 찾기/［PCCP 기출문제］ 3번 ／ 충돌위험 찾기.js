function solution(points, routes) {
    processData(points, routes);
    
    const bestRoutes = routes.map(route => searchBestRoute(points, route));
    
    return countConflict(bestRoutes);
}

const processData = (points, routes) => {
    const processIndex = (array) => {
        for (let i = 0; i < array.length; i++) {
            array[i]--;
        }
    }
    
    points.forEach(processIndex);
    routes.forEach(processIndex);
}

const searchBestRoute = (points, route) => {
    const bestRoute = [];
    let start = route[0];
    
    bestRoute.push(points[start]);
    
    for (let i = 1; i < route.length; i++) {
        const dest = route[i];
        const [destRow, destCol] = points[dest];
        let row = points[start][0];
        let col = points[start][1];
        
        while (true) {
            if (row !== destRow) {
                row += (destRow - row) > 0 ? 1 : -1;
            } else if (col !== destCol) {
                col += (destCol - col) > 0 ? 1 : -1;
            } else {
                break;
            }
            bestRoute.push([row, col]);
        }
            
        start = dest;
    }
    
    return bestRoute;
}

const countConflict = (routes) => {
    const maxLength = routes.reduce((max, route) => Math.max(max, route.length), 0);
    const map = new Map();
    let conflict = 0;
    
    for (let i = 0; i < maxLength; i++) {
        routes.forEach(route => {
            if (!route[i]) {
                return;
            }
            const [row, col] = route[i];
            const key = `${row},${col}`;
            const value = map.get(key) || 0;
            map.set(key, value + 1);
        });
        for (const value of map.values()) {
            conflict += (value > 1) ? 1 : 0;
        }
        map.clear();
    }
    
    return conflict;
}