function solution(arr) {
    const stack = [];
    const result = []
    
    arr.forEach(num => {
        if (num === stack[0]) {
            return;
        }
        stack.pop();
        stack.push(num);
        result.push(num);
    });
    
    return result;
}