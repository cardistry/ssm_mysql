package CombinationSumIII;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.combinationSum3(3,7);
    }

    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n == 0 || k == 0)
            return res;
        DFS(k,n,9,new ArrayList<Integer>());
        return res;
    }

    void DFS(int k, int n,int cur,List<Integer> list){
        if(n == 0 && k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(n == 0 || cur == 0)
            return;
        if(cur <= n){
            list.add(cur);
            DFS(k-1,n-cur,cur-1,list);
            list.remove(list.size()-1);
        }
        DFS(k,n,cur-1,list);
    }
}

