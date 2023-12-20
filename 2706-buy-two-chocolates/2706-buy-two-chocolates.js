/**
 * @param {number[]} prices
 * @param {number} money
 * @return {number}
 */
var buyChoco = function(prices, money) {
    let sortedPrices = prices.sort((a,b) => {return a-b});
    for(let i = 0; i < sortedPrices.length; i++){
        if(prices[i] + prices[i+1] > money){
            return money;
        }
        return money - (prices[i] + prices[i+1]);
    }
};