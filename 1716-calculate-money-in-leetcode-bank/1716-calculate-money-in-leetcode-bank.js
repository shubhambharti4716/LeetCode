/**
 * @param {number} n
 * @return {number}
 */
var totalMoney = function(n) {
    const week_count = Math.floor(n / 7);
    const remaining_days = n % 7;
    
    let total = ((week_count * (week_count - 1)) / 2) * 7; 
    total += week_count * 28;
    total += ((remaining_days * (remaining_days + 1)) / 2) + (week_count * remaining_days);
    
    return total;
};