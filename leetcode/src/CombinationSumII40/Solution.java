package CombinationSumII40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer> tmp = new ArrayList<Integer>();
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(target == 0)
            return res;
        Arrays.sort(candidates);
        DFS(0,candidates,target);
        return res;

    }
    void DFS(int index,int[] candidates,int target){
        if(target == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(index == candidates.length || target < 0)
            return;
        if(candidates[index] <= target){
            tmp.add(candidates[index]);
            DFS(index + 1,candidates,target - candidates[index]);
            tmp.remove(tmp.size()- 1);
        }
        while (index + 1 < candidates.length && candidates[index + 1] == candidates[index])
            ++index;
        DFS(index + 1,candidates,target);

    }
}