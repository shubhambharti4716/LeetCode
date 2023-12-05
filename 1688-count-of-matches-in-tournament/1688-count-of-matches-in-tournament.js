/**
 * @param {number} n
 * @return {number}
 */
var numberOfMatches = function(n) {
    let m=0
    while(n>1){
        if(n%2==0){
            let a=n/2
            n=n/2
            m+=a
        }
        else{
            let a=((n-1)/2)+1
            n=a
            m+=(a-1)
        }
    }
    return m
}
    