package LC738;

class Solution {
    public static void main(String[] args) {
        int a = new Solution().monotoneIncreasingDigits(1234);
        System.out.println(a);
    }
    public int monotoneIncreasingDigits(int N) {
        String s = Integer.toString(N);
        int i;
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        for (i = 0; i < s.length() -1 && s.charAt(i) <= s.charAt(i+1); i++);

        if(i == s.length() - 1)
            return N;
        while (i > 0 && s.charAt(i) == s.charAt(i-1))
            --i;
        for (int j = 0; j < i; j++)
            res.append(s.charAt(j));
        res.append(s.charAt(i)- '1');
        for (int j = i+1; j < s.length(); j++)
            res.append('9');
        return Integer.parseInt(res.toString());

    }
}
