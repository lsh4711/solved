function solution(sizes) {
    let width = 0;
    let height = 0;
    
    sizes.forEach(([w, h]) => {
        if (w < h) {
            const temp = w;
            w = h;
            h = temp;
        }
        width = Math.max(width, w);
        height = Math.max(height, h);
    });
    
    return width * height;
}