
public class Solution {

    public int countDivisibleSubstrings(String word) {
        int[] prefixSum = new int[word.length()];
        prefixSum[0] = letterToButtonDigit(word.charAt(0));
        int countDivisibleSubstrings = 1;

        for (int front = 1; front < word.length(); ++front) {

            prefixSum[front] = prefixSum[front - 1] + letterToButtonDigit(word.charAt(front));
            countDivisibleSubstrings += (prefixSum[front] % (front + 1) == 0) ? 1 : 0;

            for (int back = 0; back < front; ++back) {
                countDivisibleSubstrings += ((prefixSum[front] - prefixSum[back]) % (front - back) == 0) ? 1 : 0;
            }
        }

        return countDivisibleSubstrings;
    }

    /*
     a,b => 1 | c,d,e => 2 | f,g,h => 3 | i,j,k => 4 | l,m,n => 5
     o,p,q => 6 | r,s,t => 7 | u,v,w => 8 | x,y,z => 9
     */
    private int letterToButtonDigit(char letter) {
        return (letter - 'a' + 4) / 3;
    }
}
