package LC1208;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int start = 0,end = 0,res = 0,cur = 0;
        int [] cost = new int[length];
        for (int i = 0; i < length; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        while (end < length){
             cur += cost[end];
             if(cur > maxCost){
                 cur -= cost[start];
                 start++;
             }
             else
                 ++res;
             ++end;
        }
        return res;
    }
}