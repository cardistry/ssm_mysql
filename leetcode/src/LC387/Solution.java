package LC387;

class Solution {
    public int firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        int[] flag = new int[128];
        int index = 0;
        for (int i = ch.length - 1; i >= 0 ; i--) {
            char cur = ch[i];
            flag[cur]++;
        }
        for (int i = 0; i < ch.length; i++) {
            char cur = ch[i];
                if(flag[cur] == 1)
                    return i;
        }
        return -1;
    }
}