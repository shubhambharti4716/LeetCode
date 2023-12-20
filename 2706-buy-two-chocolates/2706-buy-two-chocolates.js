/**
 * @param {number[]} prices
 * @param {number} money
 * @return {number}
 */
var buyChoco = function(prices, money) {
    prices.sort(function(a , b) {
       return a - b
    })
    let cost = prices[0] + prices[1]
    return cost > money ? money : money - cost ?? 0

    if(money == cost)
        return 0
    if(cost > money) {
        return money
    }

    if(cost < money ) {
        return money - cost
    }

};