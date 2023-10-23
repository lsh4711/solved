function solution(wallpaper) {
    return findSquare(wallpaper);
}
    
const findSquare = (wallpaper) => {
    const result = [wallpaper.length, wallpaper[0].length, 0, 0];
    
    for (let i = 0; i < wallpaper.length; i++) {
        for (let j = 0; j < wallpaper[0].length; j++) {
            const now = wallpaper[i][j];
            if (now !== '#') {
                continue;
            }
            if (i < result[0]) {
                result[0] = i;
            }
            if (j < result[1]) {
                result[1] = j;
            }
            if (i >= result[2]) {
                result[2] = i + 1;
            }
            if (j >= result[3]) {
                result[3] = j + 1;
            }
        }
    }

    return result;
}