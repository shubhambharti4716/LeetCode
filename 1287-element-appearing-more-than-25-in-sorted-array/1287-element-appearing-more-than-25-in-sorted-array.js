/**
 * @param {number[]} arr
 * @return {number}
 */
var findSpecialInteger = function(arr) {
    if(arr.length === 1) return arr[0];
    let count = 1;
    for(let i = 0; i < arr.length; i++){
        let int = arr[i];
        if(int === arr[i+1]){
            count = count + 1
        } else count = 1

        if(count > arr.length/4 ){
            return int
        }
    }
    
};