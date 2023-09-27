/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var decodeAtIndex = function(s, k) {
    let size = BigInt(0);

	for (let index = 0; index < s.length; index++) {
		const c = s[index];

		size = isNaN(c) ? size + BigInt(1) : size * BigInt(c);
	}

	for (let index = s.length - 1; index >= 0; index--) {
		const c = s[index];
		const isNumber = !isNaN(c);

		k = BigInt(k) % size;
		if (k === 0n && !isNumber) return c;

		size = isNumber ? size / BigInt(c) : size - BigInt(1);
	}
	return '';
};