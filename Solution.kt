
class Solution {
    fun countDivisibleSubstrings(word: String): Int {
        val prefixSum = IntArray(word.length);
        prefixSum[0] = letterToButtonDigit(word[0]);
        var countDivisibleSubstrings = 1;

        for (front in 1..<word.length) {

            prefixSum[front] = prefixSum[front - 1] + letterToButtonDigit(word[front]);
            countDivisibleSubstrings += if (prefixSum[front] % (front + 1) == 0) 1 else 0;

            for (back in 0..<front) {
                countDivisibleSubstrings += if ((prefixSum[front] - prefixSum[back]) % (front - back) == 0) 1 else 0;
            }
        }

        return countDivisibleSubstrings;
    }

    /*
     a,b => 1 | c,d,e => 2 | f,g,h => 3 | i,j,k => 4 | l,m,n => 5
     o,p,q => 6 | r,s,t => 7 | u,v,w => 8 | x,y,z => 9
     */
    fun letterToButtonDigit(letter: Char): Int {
        return (letter - 'a' + 4) / 3;
    }
}
