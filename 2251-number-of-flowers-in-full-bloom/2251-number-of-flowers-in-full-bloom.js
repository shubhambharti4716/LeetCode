/**
 * @param {number[][]} flowers
 * @param {number[]} people
 * @return {number[]}
 */
var fullBloomFlowers = function (flowers, people) {
    const diff = new Map();
    for (const [start, end] of flowers) {
        diff.set(start, (diff.get(start) ?? 0) + 1);
        diff.set(end + 1, (diff.get(end + 1) ?? 0) - 1);
    }
    const times = [...diff.keys()].sort((a, b) => a - b);

    const id = [...people.keys()].sort((i, j) => people[i] - people[j]);
    let j = 0, sum = 0;
    for (const i of id) {
        while (j < times.length && times[j] <= people[i]) {
            sum += diff.get(times[j++]);
        }
        people[i] = sum;
    }
    return people;
};