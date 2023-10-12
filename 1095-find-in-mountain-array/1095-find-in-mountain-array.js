/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * function MountainArray() {
 *     @param {number} index
 *     @return {number}
 *     this.get = function(index) {
 *         ...
 *     };
 *
 *     @return {number}
 *     this.length = function() {
 *         ...
 *     };
 * };
 */

/**
 * @param {number} target
 * @param {MountainArray} mountainArr
 * @return {number}
 */
var findInMountainArray = function(target, mountainArr) {
    let peakIndex = peak(mountainArr); 
        // Getting the index of peak element.

    let first = search(mountainArr, target, 0, peakIndex);
        // Binary search left side of the array.

    if(first != -1) { 
        // If the answer is found return the index
        return first;
    }

    return search(mountainArr, target, peakIndex+1, mountainArr.length()-1);
        // Binary search the right side of array.


function peak(nums) {
    let l = 0;
    let r = nums.length()-1;
    while(l<r) {
        mid = Math.floor(l+(r-l)/2);
        if(nums.get(mid)>nums.get(mid+1)){
            // answer lies in the left of mid
            r = mid;
        }else {
            // answer lies in the right of mid
            l = mid+1;
        }
    }
    return l;
};
    
    
function search(arr, target, l, r) {
    isAsc = arr.get(l)<arr.get(r); 
        // check if it's increasing or decreasing side of array.

    // ---- Binary Search ----
    while (l<=r) {
        mid = Math.floor(l+(r-l)/2);
        if(arr.get(mid)==target) return mid;
        if(isAsc){
            if(target<arr.get(mid)){
                r = mid-1;
            } else {
                l = mid+1;
            }
        } else {
            if(target<arr.get(mid)){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
    }
    return -1;
}   
};