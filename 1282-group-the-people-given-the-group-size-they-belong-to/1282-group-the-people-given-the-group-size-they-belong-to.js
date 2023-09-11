/**
 * @param {number[]} groupSizes
 * @return {number[][]}
 */
var groupThePeople = function(groupSizes) {
    const temp_group = {};
    const result = [];
    
    for(let i = 0; i < groupSizes.length; i++) {
        const size = groupSizes[i];
        if (!temp_group[size]) {
            temp_group[size] = [];
        }
        temp_group[size].push(i);
        
        if(temp_group[size].length === size) {
            result.push([...temp_group[size]]);
            temp_group[size] = [];
        }
    }
    return result;
};