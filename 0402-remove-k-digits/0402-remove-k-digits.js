/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function(num, k) {
    if(num.length ==k) return '0'
    const res = []
   for(let i=0;i<num.length;i++){
        while(k>0 && res.length>0 && res[res.length-1]>num[i]){
            res.pop()
            k--
        }
        
        if(res.length ==0 && num[i]=='0') continue
        res.push(num[i])
   }

   while(k>0 && res.length>0) {
    k--;
    res.pop();
   }

   return res.length ==0 ?'0':res.join('')
};