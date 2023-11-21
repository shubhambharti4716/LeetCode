/**
 * @param {number[]} nums
 * @return {number}
 */
function countNicePairs(nums) 
{
    const counts = new Map();
    
    for (const num of nums) 
    {
        const rev = reverse(num);
        const diff = rev - num;
        
        const count = counts.get(diff);
        
        counts.set(diff, count ? count + 1 : 1);
    }
    
    let sum = 0;
    
    for (const [key, value] of counts) 
    {
        sum += (value - 1) * value / 2;
    }
    
    return sum % 1000000007;
}

function reverse(num) 
{
    let n = 0;
    
    while (num > 0) 
    {
        const modulo = num % 10;
        
        n = n * 10 + modulo;
        num = (num - modulo) / 10;
    }
    
    return n;
}