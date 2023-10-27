/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
        let T = "^#" + s.split("").join("#") + "#$";
        let n = T.length;
        let P = new Array(n).fill(0);
        let C = 0, R = 0;
        
        for (let i = 1; i < n-1; i++) {
            P[i] = (R > i) ? Math.min(R - i, P[2*C - i]) : 0;
            while (T[i + 1 + P[i]] === T[i - 1 - P[i]])
                P[i]++;
            
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        
        let max_len = Math.max(...P);
        let center_index = P.indexOf(max_len);
        return s.substring((center_index - max_len) / 2, (center_index + max_len) / 2);
    }