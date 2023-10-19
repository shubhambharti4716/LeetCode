/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var backspaceCompare = function(s, t) {
    var ss=[];
    var ts=[];
    var i=0;
    while(i<s.length)
    {
      if(s[i]=="#")
      {
        ss.pop();
      }
      else
      {
        ss.push(s[i]);
      }
      i++;
    }
    var j=0;
    while(j<t.length)
    {
      if(t[j]=="#")
      {
        ts.pop();
      }
      else
      {
        ts.push(t[j]);
      }
      j++;
    }
    var f=ss.join("");
    var l=ts.join("");
    if(f==l)
    {
      return true;
    }
    return false;
};