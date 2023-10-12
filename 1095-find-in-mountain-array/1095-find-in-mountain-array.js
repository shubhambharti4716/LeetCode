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
    let start2 = 0;
    let end2 = mountainArr.length() - 1;
    let mid;

    while(start2 < end2){
        mid = parseInt(start2 + (end2 - start2) / 2);

        if(mountainArr.get(mid) > mountainArr.get(mid + 1)){
            end2 = mid;
        } else {
            start2 = mid + 1
        }
    }

    let start1 = 0;
    let end1 = start2 - 1;
    end2 = mountainArr.length() - 1;

    const result1 =  binarySearch(mountainArr, start1, end1, target)
    const result2 =  binarySearch(mountainArr, start2, end2, target)

    return result1 !== -1 ? result1 : result2;

    function binarySearch(arr, start, end, target){
        const isDec = arr.get(start) > arr.get(end);
        let mid;

        while(start <= end){
            
            mid = parseInt(start + (end - start) / 2);

            if(arr.get(mid) < target) {
                if(isDec){
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            } else if (arr.get(mid) > target) {
                if(isDec){
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            } else {
                return mid
            }
        }
        return -1;
    }
};