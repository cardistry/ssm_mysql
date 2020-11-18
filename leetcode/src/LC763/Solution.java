package LC763;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*

暴力解法
*
*
* */
class Solution1 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        int start = 0;
        int lengh = 1;
        int to = 0;
        while (to < S.length()){
            for(int i = start; i <= to;++i){
                for(int j = to + 1;j < S.length();++j){
                    if(S.charAt(j) == S.charAt(i)) {
                        to = j;
                    }
                }
            }
            res.add(to - start + 1);
            start = to + 1;
            to = start;

        }  
        return res;
    }
}

//哈希
class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S ==null  || S.length() == 0) {
            return null;
        }
        int len = S.length();

        // 做映射表，记录每个字母最后出现的位置
        int[] ma = new int[26];
        for (int i = 0; i < len; ++i) {
            ma[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int left = 0;
        while (left < len) {
            char curLeft = S.charAt(left);
            // 最小右边界
            int right = ma[curLeft - 'a'];
            for (int i = left + 1; i < right; ++i) {
                // 枚举当前分段中的字符，更新右边界
                if (ma[S.charAt(i) - 'a'] > right) {
                    right = ma[S.charAt(i) - 'a'];
                }
            }
            // 至此，一个新的片段生成了
            ans.add(right - left + 1);
            // 分析下一段
            left = right + 1;
        }
        return ans;

    }
}