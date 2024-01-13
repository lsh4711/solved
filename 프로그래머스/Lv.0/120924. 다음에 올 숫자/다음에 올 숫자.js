function solution(common) {
    const first = common[0];
    const second = common[1];
    const third = common[2];
    const last = common[common.length - 1];
    
    return first - second === second - third
            ? last + second - first
            : last * second / first;
}