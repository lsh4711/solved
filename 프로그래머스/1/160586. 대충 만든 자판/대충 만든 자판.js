function solution(keymap, targets) {
    const result = [];
    const map = initMap(keymap);

    for (const str of targets) {
        result.push(getMinCount(map, str));
    }
    
    return result;
}

const initMap = (keymap) => {
    const map = new Map();
    
    for (str of keymap) {
        const chars = str.split("");
        for (let i = 0; i < chars.length; i++) {
            const value = map.get(chars[i]);
            if (value === undefined || value > i + 1) {
                map.set(chars[i], i + 1);
            }
        }
    }
    
    return map;
}

const getMinCount = (map, target) => {
    let result = 0;
    
    for (const char of target.split("")) {
        const cnt = map.get(char);
        if (cnt !== undefined) {
            result += cnt;
        } else {
            return -1;  
        }
    }
    
    return result;
}