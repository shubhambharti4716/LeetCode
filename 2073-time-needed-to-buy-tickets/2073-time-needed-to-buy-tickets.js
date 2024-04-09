/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */
var timeRequiredToBuy = function(tickets, k) {
    let total = 0;

    for (let i = 0; i < tickets.length; i++) {
        if (i <= k) {
            total += Math.min(tickets[i], tickets[k]);
        } else {
            total += Math.min(tickets[i], tickets[k] - 1);
        }
    }

    return total;
};