package sword58Ⅰ;

class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >=0;--i){
            res.append(strs[i]);
            if(i != 0)
                res.append(" ");
        }
        return String.valueOf(res);
    }
}