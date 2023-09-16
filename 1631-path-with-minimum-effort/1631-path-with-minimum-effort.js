/**
 * @param {number[][]} heights
 * @return {number}
 */
var minimumEffortPath = function(heights) {
     const dir = [[-1,0],[0,-1],[0,1],[1,0]];
 
    const costs = [];
    const visited = [];
    for(let i=0;i<heights.length;i++){
        costs[i]= [];
        visited[i]= [];
        for(let j=0;j<heights[0].length;j++){
            costs[i][j]= Infinity;
            visited[i][j]= false;
        }
    }
    
    costs[0][0] = 0;
    const queue = new PQ((a,b)=>a[2]-b[2]);
    queue.add([0,0,0]);
    
    while(queue.getSize()>0){
        const [i,j,cost] = queue.remove();
        visited[i][j]= true;
        
        if(i===heights.length-1 && j===heights[0].length-1) return cost;
       
        dir.map(item=>{
            const row = item[0]+i, col = item[1]+j;
                if(row>=0 
                   && col>=0 
                   && row<heights.length 
                   && col<heights[0].length 
                   && visited[row][col]==false){
                    
                    const diff  =  Math.abs(heights[i][j]-heights[row][col]);
                    const currentDiff= Math.max(costs[i][j],diff);
                    
                    if(costs[row][col]>currentDiff){
                        costs[row][col] = currentDiff; 
                        queue.add([row,col,currentDiff]);
                    }
                }
        });
    }
    return costs[heights.length-1][heights[0].length-1];
};

function PQ(compareFn){
    this.heap = [];
    this.compareFn = compareFn;
}

PQ.prototype.peek =function(){
    return this.heap[1];
}

PQ.prototype.getSize = function () {
    return this.heap.length > 1 ? this.heap.length - 1 : 0;
};


PQ.prototype.add = function(el){
    const index= this.heap.length> 1 ? this.heap.length : 1;
    this.heap[index] = el;
    this.heapifyUp(index);
}

PQ.prototype.heapifyUp = function(index){
    if(index<=1) return;
    const el = this.heap[index];
    const parentIndex = Math.floor(index/2);
    const parentEl = this.heap[parentIndex];
    
    if(this.compareFn(parentEl,el)>0){
        this.heap[index] = parentEl;
        this.heap[parentIndex] = el;
        this.heapifyUp(parentIndex);
    }
}

PQ.prototype.remove = function(){
    if(this.heap.length<=1) return;
    if(this.heap.length===2) return this.heap.pop();
    
    const el = this.heap[1];
    this.heap[1]= this.heap[this.heap.length-1];
    this.heap.pop();
    this.heapifyDown(1);
    return el;  
    
}

PQ.prototype.heapifyDown = function(index){
    if(index>=this.heap.length-1) return;
    const el  = this.heap[index];
    const leftIndex = index * 2;
    const rightIndex = leftIndex +1;
    const leftEl = this.heap[leftIndex];
    const rightEl = this.heap[rightIndex];
    
    if((leftEl && this.compareFn(el,leftEl)>0) || (rightEl && this.compareFn(el,rightEl)>0)){
        const newIndex = !rightEl || this.compareFn(rightEl,leftEl) >= 0 ? leftIndex : rightIndex;
        this.heap[index] = this.heap[newIndex]; 
        this.heap[newIndex] = el;
        this.heapifyDown(newIndex);
    }
    
}
 
    