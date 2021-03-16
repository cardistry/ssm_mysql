package Interview17_22;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    List<String> res = new LinkedList<>();
    List<String> wordList = new LinkedList();
    Set<String> set = new HashSet<>();
    boolean flag = false;
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        this.wordList = wordList;

        Set<String> visited = new HashSet<>();
        List<String> tmp = new LinkedList<>();
        visited.add(beginWord);
        tmp.add(beginWord);
        dfs(beginWord,endWord,visited,tmp);
        return res;
    }
    public void dfs(String cur, String endWord,Set<String> visited,List<String> tmp){
        if(flag)
            return;
        if(cur.equals(endWord)){
            res = new LinkedList(tmp);
            flag = true;
            return;
        }
        for(String str : wordList ){
            if(set.contains(str) || visited.contains(str) || !isValued(cur,str))
                continue;
            tmp.add(str);
            visited.add(str);
            dfs(str,endWord,visited,tmp);
            tmp.remove(tmp.size() - 1);
            visited.remove(str);
            set.add(cur);
        }

    }
    public boolean isValued(String s1,String s2){
        int diff = 0;
        for(int i = 0; i < s1.length(); ++i){
            if(s1.charAt(i) != s2.charAt(i))
                ++diff;
        }
        return diff <= 1;
    }
}