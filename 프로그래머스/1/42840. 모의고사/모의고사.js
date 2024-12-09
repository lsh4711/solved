function solution(answers) {
    const students = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ];
    const solves = [0, 0, 0];
    
    answers.forEach((answer, idx) =>{
        students.forEach((numbers, studentIdx) => {
            const num = getSelectedNumber(idx, numbers);
            if (num === answer) {
                solves[studentIdx]++;
            }
        })
    });
    
    let max = 0;
    
    return solves.reduce((result, solve, idx) => {
        if (solve < max) {
            return result;
        }
        if (solve > max) {
            result.length = 0;
            max = solve;
        }
        result.push(idx + 1);
        return result;
    }, []);
}

const getSelectedNumber = (index, numbers) => {
    const idx = (index % numbers.length);
    return numbers[idx];
}