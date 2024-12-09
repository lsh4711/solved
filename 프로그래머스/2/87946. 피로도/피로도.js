let result = 0;

function solution(k, dungeons) {
    dfs(k, dungeons, 0);
    return result;
}

const dfs = (stamina, dungeons, count) => {
    result = Math.max(result, count);
    
    for (let i = 0; i < dungeons.length; i++) {
        const [require, cost] = dungeons[i];
        if (require === undefined || require > stamina) {
            continue;
        }
        const temp = dungeons[i];
        dungeons[i] = [];
        dfs(stamina - cost, dungeons, count + 1)
        dungeons[i] = temp;
    }
}