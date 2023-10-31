/**
 * @param {number[]} pref
 * @return {number[]}
 */
var findArray = function (pref) {
    let arr = [];
    arr[0] = pref[0];

    for (let i = 1; i < pref.length; i++) {
        arr[i] = pref[i] ^ pref[i - 1];
    }
    return arr;
};