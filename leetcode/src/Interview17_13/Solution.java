package Interview17_13;

import java.util.*;

class Solution {
    public int respace(String[] dictionary, String sentence){
        Set<String> dic = new HashSet<>();
        // <最后一个字符，这样的单词长度有哪些>
        Map<Character, Set<Integer>> map = new HashMap<>();
        for(String str: dictionary){
            dic.add(str);
            int len = str.length();
            char c = str.charAt(len-1);
            Set<Integer> set = map.getOrDefault(c, new HashSet<>());
            set.add(len);
            map.put(c, set);
        }

        int n = sentence.length();
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1]+1;
            char c = sentence.charAt(i-1);
            if(map.containsKey(c)){
                Set<Integer> lens = map.get(c);
                // for(int l: lens){
                //     if(i>=l && dic.contains(sentence.substring(i-l,i))){
                //         dp[i] = Math.min(dp[i], dp[i-l]);
                //     }
                // }
                //使用迭代器比直接foreach要快些
                Iterator<Integer> it = lens.iterator();
                while(it.hasNext()){
                    int l = it.next();
                    if(i>=l && dic.contains(sentence.substring(i-l,i))){
                        dp[i] = Math.min(dp[i], dp[i-l]);
                    }
                }
            }
        }
        return dp[n];
    }
}


