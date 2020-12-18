package Interview812;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<int[]> res = new ArrayList<>();
    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resmap = new ArrayList<>();
        //List<List<Integer>> res = new ArrayList<>();
        int[] map = new int[n];
        for (int i = 0; i < n; i++)
            map[i] = -1;
        mysolveNQueens(n,0,map);
        int length = res.size();
        for (int i = 0; i < length; i++) {
            int[] curlist = res.get(i);
            List<String> chess = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                char[] s = new char[n];
                for (int k = 0; k < n; k++) {
                    if(k == curlist[j])
                        s[k] = 'Q';
                    else
                        s[k] = '.';
                }

                chess.add(String.valueOf(s));

            }
            resmap.add(chess);
        }
        return resmap;


    }
    public void mysolveNQueens(int n, int cur, int[] map){
        if(cur == n){
            res.add(map.clone());
            return;
        }

        for (int i = 0; i < n; i++) {
            if(checkNQueens(map,cur,i)){
                map[cur]=i;
                mysolveNQueens(n,cur + 1,map);
            }
            else
                continue;
        }
        map[cur] = -1;
    }
    public boolean checkNQueens(int[] map,int cur,int value) {
        for (int i = 0; i < cur; i++) {
            if(value == map[i] || value - map[i] == cur - i || value - map[i] == i - cur)
                return false;
        }
        return true;
    }
}