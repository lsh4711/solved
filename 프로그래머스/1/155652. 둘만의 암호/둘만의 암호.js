function solution(s, skip, index) {
    const offsets = Array.from({length: 123}, () => 0);
    
    for (const char of skip.split("")) {
        offsets[char.charCodeAt()] = 1;
    }
    
    const result = [];
    
    for (const char of s.split("")) {
        let cnt = index;
        let ascii = char.charCodeAt();
        while (cnt-- > 0) {
            if (++ascii === 123) {
                ascii = 97;
            }
            cnt += offsets[ascii];
        }
        result.push(String.fromCharCode(ascii));
    }
    
    return result.join("");
}