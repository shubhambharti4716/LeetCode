/**
 * @param {number[]} jobDifficulty
 * @param {number} d
 * @return {number}
 */
var minDifficulty = function(jobDifficulty, days) {
    let length = jobDifficulty.length;
    if (days > length) return -1;

    let minDifficulties = new Array(days).fill().map(() => new Array(length).fill(Number.MAX_SAFE_INTEGER));

    let maxDiff = 0;
    let i = 0;
    while (i <= length - days) {
        maxDiff = Math.max(maxDiff, jobDifficulty[i]);
        minDifficulties[0][i] = maxDiff;
        ++i;
    }

    let currentDay = 1;
    while (currentDay < days) {
        let to = currentDay;
        while (to <= length - days + currentDay) {
            let currentJobDifficulty = jobDifficulty[to];
            let result = Number.MAX_SAFE_INTEGER;
            let j = to - 1;
            while (j >= currentDay - 1) {
                result = Math.min(result, minDifficulties[currentDay - 1][j] + currentJobDifficulty);
                currentJobDifficulty = Math.max(currentJobDifficulty, jobDifficulty[j]);
                --j;
            }
            minDifficulties[currentDay][to] = result;
            ++to;
        }
        ++currentDay;
    }

    return minDifficulties[days - 1][length - 1];
};

