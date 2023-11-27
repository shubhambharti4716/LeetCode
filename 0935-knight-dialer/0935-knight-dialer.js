/**
 * @param {number} n
 * @return {number}
 */

var getNext = function(pos){
    switch (pos){
        case 0:
            return [4,6]
        case 1:
            return [8,6]
        case 2:
            return [7,9]
                            case 3:
            return [8,4]
                            case 4:
            return [0,3,9]
                            case 5:
            return []
                            case 6:
            return [0,1,7]
                            case 7:
            return [2,6]
                            case 8:
            return [1,3]
                                                case 9:
            return [2,4]
    }

                    
    
}

var knightDialer = function(n) {
    // dp[k][j] => knight at jth position in k jumps => distinct phone numbers
    
    let dp = Array(n+1).fill().map(()=>Array(10));
    
    for(let i=0;i<10;i++){
        dp[1][i]=1
    }
    let op=0;
    
    if(n===1){
        return 10
    }
    for(let i=2;i<=n;i++){
        for(let j=0;j<10;j++){
            dp[i][j]=0
            let nextPoints = getNext(j);
            for(let k=0;k<nextPoints.length;k++){
                let nextP = nextPoints[k];
                dp[i][j] = (dp[i][j] + dp[i-1][nextP])%1000000007
            }
            if(i===n){
                op=(op+dp[i][j])%1000000007
            }
        }
    }
    
    return op
    
    
};