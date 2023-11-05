/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
function swap(a,b){
    let temp=a;
    a=b;
    b=temp;
}

var getWinner = function(arr, k) {
    
    
    let final_pos=arr[0];
    let win=0;
    for(let i=1;i <arr.length;i++){
      const v=arr[i];
      if(v<=final_pos)win++;
      else{
        final_pos=v;
        win=1;
      }
      if(win==k)return final_pos;
    }
    return final_pos;
};