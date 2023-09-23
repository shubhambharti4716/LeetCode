/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function(words) {
    words.sort((a, b) => a.length - b.length);
	const map = new Map();
	let result = 0;
	for (let word of words) {
		let max = 0;
		for (let i = 0; i < word.length; i++) {
			const prev = word.slice(0, i) + word.slice(i + 1);
			max = Math.max(max, (map.get(prev) || 0) + 1);
		}
		map.set(word, max);
		result = Math.max(result, max);
	}
	return result;
};