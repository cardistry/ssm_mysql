package LC389;

class Solution {
    public static void main(String[] args) {
        new Solution().findTheDifference("abcd","abcde");
    }
    public char findTheDifference(String s, String t) {
        char num = 0;
        for(char c:s.toCharArray()){
            num ^= c;
        }
        for (char c:t.toCharArray())
            num ^= c;
        return num;
    }

}