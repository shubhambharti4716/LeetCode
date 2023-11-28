/**
 * @param {string} corridor
 * @return {number}
 */
var numberOfWays = function(corridor) {

    let ans = 1;
    let start = 0;

    // remove left side plants
    while(start < corridor.length && corridor[start] != "S") start++;
    if(start == corridor.length) return 0;

    //remove right plants
    let end = corridor.length-1;
    while(corridor[end] == "P") end--;

    corridor = corridor.substring(start, end+1);
    start = 0;
    end = corridor.length
    while(start < end){
        let chairs = 0;
        let plants = 1;

        // get 2 chairs  
        while(start < end && chairs != 2) {
            if(corridor[start++] == "S") chairs++;
        }
      
        // if chairs != 2, we can not have this combination  
        if(start == end && chairs != 2) return 0;

        // find out number of plants between two groups of 2 chairs
        while(start < end && corridor[start]!= "S"){
            plants++;
            start++;
        }
      
        ans = (ans * plants) % (1e9+7);
    }
    return ans;
};