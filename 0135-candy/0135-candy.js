/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function(ratings) {
    let total = 1,increasing = 1,decreasing = 0,largestCandyGiven = 0;

    for(let i = 1;i<ratings.length;i++) {
      let el = ratings[i];
      let prevEl = ratings[i-1];

      if(el > prevEl) {
        largestCandyGiven = ++increasing;
        decreasing = 0;
        total += increasing ;
      }
      else if (el < prevEl) {
          increasing = 1;
          ++decreasing;
          total += decreasing ;
          if(  decreasing >= largestCandyGiven) total += 1;
      }
      else {
          increasing = 1;
          decreasing = largestCandyGiven = 0;
          total += 1;
      }
    }
    
    return total;
};