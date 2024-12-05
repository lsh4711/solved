function solution(clothes) {
    const map = new Map();
    
    clothes.forEach(([name, category]) => {
        const value = (map.get(category) || 1 ) + 1;
        map.set(category, value);
    });
    
    let result = 1;
    
    for (const [category, value] of map.entries()) {
        result *= value;
    }
    
    return result - 1;
}