/**
 * @param {number[]} jobDifficulty
 * @param {number} d
 * @return {number}
 */
let recurse=function(job, d, start, n,memo){
    if(memo[d][start]!=null)
        return memo[d][start];
    if(d==1){
        let res = Math.max(...job.slice(start,n))
        return memo[d][start]= res;
    }
    else{
        let val = -Infinity;
        let res = +Infinity;

        for(let i=start;i<(n-d+1);i++){              
            val = Math.max(val,job[i])            
            res = Math.min(res,val+recurse(job,d-1,i+1,n,memo))          
        } 
        return  memo[d][start]= res;
    }
}

var minDifficulty = function(jobDifficulty, d) {
    const n = jobDifficulty.length
    if(n<d) return -1

    let memo = new Array(d+1)
    for(let i=0;i<memo.length;i++){
        memo[i]=new Array(n+1).fill(null)
    }
    
    return recurse(jobDifficulty,d,0,n,memo)    
};