package sword48;

class Solution {
    public static void main(String[] args) {
        String string = "bbb";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(string));
    }
    public int lengthOfLongestSubstring(String s) {
        int max,cur,laststart;
        max = cur = laststart = 0;
        for(int i = 0; i < s.length(); ++i){
            int start = find(s,laststart,i);
            cur = i - start;
            max = max > cur ? max : cur;
            laststart = start + 1;
        }
        return max;
    }

    int find(String s,int start,int end){
        int index = end - 1;
        while(index >=start){
            if(s.charAt(index) == s.charAt(end))
                break;
            --index;
        }
       return index;
    }
}