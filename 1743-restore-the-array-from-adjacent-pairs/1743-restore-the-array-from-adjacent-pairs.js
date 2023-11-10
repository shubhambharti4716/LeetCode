/**
 * @param {number[][]} adjacentPairs
 * @return {number[]}
 */
var restoreArray = function(adjacentPairs) {
    const map = new Map();
    const result = [];

    for(let i = 0; i < adjacentPairs.length; i++){
        if(map.get(adjacentPairs[i][0])){
            const aux = map.get(adjacentPairs[i][0]);
            aux.push(adjacentPairs[i][1]);
            map.set(adjacentPairs[i][0], aux)
        }else{
            map.set(adjacentPairs[i][0], [adjacentPairs[i][1]])
        }

        if(map.get(adjacentPairs[i][1])){
            const aux = map.get(adjacentPairs[i][1]);
            aux.push(adjacentPairs[i][0]);
            map.set(adjacentPairs[i][1], aux)
        }else{
            map.set(adjacentPairs[i][1], [adjacentPairs[i][0]])
        }
    }

    let currentNumber;
    let previousNumber;
    for (let [key, value] of map) {
        if(value.length == 1) {
            currentNumber = key;
            previousNumber = key;
            break;
        }
    }

    while(result.length != adjacentPairs.length + 1){
        result.push(currentNumber);
        const nextNumber = map.get(currentNumber).find(data => data != previousNumber);
        previousNumber = currentNumber;
        currentNumber = nextNumber;
    }

    return result;
};