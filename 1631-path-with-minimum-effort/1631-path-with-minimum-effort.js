/**
 * @param {number[][]} heights
 * @return {number}
 */
var minimumEffortPath = function(heights) {
    const directions = [[-1, 0], [0, -1], [1, 0], [0, 1]],
          visited = new Array(heights.length).fill(null).map(() => new Array(heights[0].length).fill(false)),
          cache = new Array(heights.length).fill(null).map(() => new Array(heights[0].length).fill(Infinity));
    
    let minEffort = Infinity;
    const nextDirs = new MinPriorityQueue();
    
    const dfs = ([row, col], currEffort) => {
        //We have achieved our goal;
        if (row === 0 && col === 0) {
            minEffort = Math.min(minEffort, currEffort);
            nextDirs.clear();
            return;
        }
        
        if (visited[row][col])
            return;
        
        //We don't want to visit the same node twice.
        visited[row][col] = true;
        
        //This is the current less effort for this node;
        cache[row][col] = currEffort;
        
        directions.forEach(([rowDirection, colDirection]) => {
            const newRow = rowDirection + row, newCol = colDirection + col;

            if (newRow < 0 || newRow === heights.length || 
                newCol < 0 || newCol === heights[0].length || 
                visited[newRow][newCol]) {
                return;
            }

            const nextEffort = Math.max(currEffort, Math.abs(heights[row][col] - heights[newRow][newCol]));
            
            //Since this is a MinPriorityQueue, the elements with less effort will run first.
            nextDirs.enqueue({row:newRow, col:newCol, effort:nextEffort}, nextEffort);
                
        });
        
        while(!nextDirs.isEmpty()) {
            const next = nextDirs.dequeue().element;
            //We only want to visit nodes if the effor will be less than the current effort.
            if (next.effort < cache[next.row][next.col]) {
                dfs([next.row, next.col], next.effort);
            }
        }
        
        // We unvisit this node.
        visited[row][col] = false;
    }
    dfs([heights.length - 1, heights[0].length - 1], -1);
    return minEffort === -1 ? 0 : minEffort;
};

