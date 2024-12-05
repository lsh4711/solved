function solution(genres, plays) {
    const genreInfoMap = new Map();
    
    genres.forEach((genre, idx) => {
        const play = plays[idx];
        const info = genreInfoMap.get(genre) || {
            play: 0,
            songs: []
        };
        info.play += play;
        info.songs.push([idx, play]);
        genreInfoMap.set(genre, info);
    })
    
    const genreInfos = [...genreInfoMap.values()];
    
    const result = [];
    
    genreInfos
        .sort((genre1, genre2) => genre2.play - genre1.play)
        .flatMap(({songs}) => {
            songs.sort((song1, song2) => song2[1] - song1[1]);
            for (let i = 0; i < 2; i++) {
                const song = songs[i];
                if (!song) {
                    break;
                }
                result.push(song[0]);
            }
        });
    
    return result;
}