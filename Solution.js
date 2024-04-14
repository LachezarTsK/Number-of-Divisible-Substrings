
/**
 * @param {string} word
 * @return {number}
 */
var countDivisibleSubstrings = function (word) {
    const prefixSum = new Array(word.length).fill(0);
    prefixSum[0] = letterToButtonDigit(word.charAt(0));
    let countDivisibleSubstrings = 1;

    for (let front = 1; front < word.length; ++front) {

        prefixSum[front] = prefixSum[front - 1] + letterToButtonDigit(word.charAt(front));
        countDivisibleSubstrings += (prefixSum[front] % (front + 1) === 0) ? 1 : 0;

        for (let back = 0; back < front; ++back) {
            countDivisibleSubstrings += ((prefixSum[front] - prefixSum[back]) % (front - back) === 0) ? 1 : 0;
        }
    }

    return countDivisibleSubstrings;
};

/*
 a,b => 1 | c,d,e => 2 | f,g,h => 3 | i,j,k => 4 | l,m,n => 5
 o,p,q => 6 | r,s,t => 7 | u,v,w => 8 | x,y,z => 9
 */
/**
 * @param {string} letter
 * @return {number}
 */
function letterToButtonDigit(letter) {
    return Math.floor((letter.codePointAt(0) - 'a'.codePointAt(0) + 4) / 3);
}
