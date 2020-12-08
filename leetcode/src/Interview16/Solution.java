package Interview16;

class Solution {
    public String compressString(String S) {
        StringBuilder res = new StringBuilder();
        int start = 0;
        while (start < S.length()){
            int count = 1;
            while (start + 1 < S.length() && S.charAt(start) == S.charAt(start + 1)){
                ++count;
                ++start;
            }
            res.append(S.charAt(start));
            res.append(count);
            ++start;
        }
        return S.length() > res.length() ? res.toString():S;
    }
}