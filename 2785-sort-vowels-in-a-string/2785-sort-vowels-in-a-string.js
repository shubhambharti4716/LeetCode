/**
 * @param {string} s
 * @return {string}
 */
var sortVowels = function(s) {
    const vowel = ["A", "E", "I", "O", "U", "a", "e", "i", "o", "u"];

  let vowelInStr = [];
  let index = [];

  let result = s.split("");

  for (let i = 0; i < s.length; i++) {
    if (vowel.includes(s[i])) {
      vowelInStr.push(s[i]);
      index.push(i);
    }
  }
  vowelInStr.sort();
  for (let i = 0; i < index.length; i++) {
    result[index[i]] = vowelInStr[i];
  }
  return result.join("");
};