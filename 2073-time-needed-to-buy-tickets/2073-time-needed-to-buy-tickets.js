/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */

var timeRequiredToBuy = function(tickets, k) {
    let queue = []
    let count = 0

    for(let i in tickets){
        queue.push({t: tickets[i], i:i})
    }

    while(true){
        const person = queue.shift()
        person.t = person.t -1
        count += 1
        if(person.t > 0) {
            queue.push(person)
        } else if(person.i == k){
            break
        } 
    }
    
    return count
};