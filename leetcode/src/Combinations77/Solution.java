package Combinations77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> tmp = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        int cur = 1;
        DFS(n, k, cur);
        return res;

    }

    void DFS(int n, int k, int cur) {
        if (cur + k > n + 1)
            return;
        if (k == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }

        DFS(n, k, cur + 1);
        tmp.add(cur);
        DFS(n, k - 1, cur + 1);
        tmp.remove(tmp.size() - 1);
    }

}