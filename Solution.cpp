
#include <array>
#include <vector>
using namespace std;

class Solution {

public:
    int countDivisibleSubstrings(const string& word) const {
        vector<int> prefixSum(word.length());
        prefixSum[0] = letterToButtonDigit(word[0]);
        int countDivisibleSubstrings = 1;

        for (size_t front = 1; front < word.length(); ++front) {

            prefixSum[front] = prefixSum[front - 1] + letterToButtonDigit(word[front]);
            countDivisibleSubstrings += (prefixSum[front] % (front + 1) == 0) ? 1 : 0;

            for (size_t back = 0; back < front; ++back) {
                countDivisibleSubstrings += ((prefixSum[front] - prefixSum[back]) % (front - back) == 0) ? 1 : 0;
            }
        }

        return countDivisibleSubstrings;
    }

private:
    /*
     a,b => 1 | c,d,e => 2 | f,g,h => 3 | i,j,k => 4 | l,m,n => 5
     o,p,q => 6 | r,s,t => 7 | u,v,w => 8 | x,y,z => 9
     */
    int letterToButtonDigit(char letter) const {
        return (letter - 'a' + 4) / 3;
    }
};
