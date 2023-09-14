var findItinerary = function(tickets) {
    var map = {};
    var res = [];
    for(var i=0; i<tickets.length; i++) {
        var dep = tickets[i][0];
        var des = tickets[i][1];
        if(map[dep]) {
            map[dep].push(des);
        } else {
            map[dep] = [des];
        }
    }
    for(let loc in map) {
        map[loc].sort();
    }  
    var dfs = function(node) {
        var des = map[node];
        while(des && des.length>0) {
            dfs(des.shift());
        }
        res.push(node);
    }
    dfs('JFK');
    return res.reverse();
};