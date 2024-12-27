const SkillType = {
    "ATTACK": 1,
    "HEAL": 2,
}

function solution(board, skills) {
    const imosBoard = initImosBoard(board);
    
    skills.forEach(skill => applySkill(skill, imosBoard));
    processImos(imosBoard, board);
    
    return countBuildings(board);
}

const initImosBoard = (board) => {
    return Array.from({length: board.length}, (_, idx) => {
        return new Array(board[idx].length).fill(0);
    });
}

const applySkill = ([type, r1, c1, r2, c2, degree], imosBoard) => {
    const range = [
        [r1, c1],
        [r2, c2],
    ];
    
    if (type === SkillType.ATTACK) {
        attack(range, degree, imosBoard);
        return;
    }
    
    if (type === SkillType.HEAL) {
        heal(range, degree, imosBoard);
        return;
    }
        
    throw new Error(`type${type} 미구현`);
}

const attack = (range, degree, imosBoard) => {
    applyDegree(range, -degree, imosBoard);
}

const heal = (range, degree, imosBoard) => {
    applyDegree(range, degree, imosBoard);
}

const applyDegree = ([start, end], degree, imosBoard) => {
    const points = [
      [start[0], end[1] + 1, -degree],
      [end[0] + 1, start[1], -degree],
      [end[0] + 1, end[1] + 1, degree],
    ];
    imosBoard[start[0]][start[1]] += degree;
    
    points.forEach(([row, col, degree]) => {
        if (row < imosBoard.length && col < imosBoard[row]?.length) {
            imosBoard[row][col] += degree;
        }
    });
}

const processImos = (imosBoard, board) => {
    imosBoard.forEach((row, rowIdx) => {
        row.forEach((_, colIdx) => {
            imosBoard[rowIdx][colIdx] += (imosBoard[rowIdx][colIdx - 1] ?? 0);
        });
        row.forEach((_, colIdx) => {
            imosBoard[rowIdx][colIdx] += (imosBoard[rowIdx - 1]?.[colIdx] ?? 0);
        });
    });
    
    board.forEach((row, rowIdx) => {
        row.forEach((col, colIdx) => board[rowIdx][colIdx] += imosBoard[rowIdx][colIdx]);
    });
}

const countBuildings = (board) => {
    let buildings = 0;
    
    board.forEach(row => {
       row.forEach(building => {
           buildings += (building > 0) ? 1 : 0;
       });
    });
    
    return buildings;
}