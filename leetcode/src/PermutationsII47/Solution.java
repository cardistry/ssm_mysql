package PermutationsII47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    private  List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        IntStream stream = Arrays.stream(nums);
        Stream<Integer> integerStream = stream.boxed();
        Integer[] newnums =  integerStream.toArray(Integer[]::new);
        DFS(newnums,0);
        return res;

    }
    void DFS(Integer[] nums,int index){
        if(index == nums.length){
            res.add(new ArrayList<Integer>(Arrays.asList(nums)));
            return;
        }

        for(int i = index; i < nums.length; ++i) {
            if(check(nums,i,index))
                continue;
            swap(nums,i,index);
            DFS(nums,index + 1);
            swap(nums,i,index);
        }
    }
    void swap(Integer[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    boolean check(Integer[] nums,int index,int start) {
        for(int i = start ; i < index; ++i){
            if(nums[i] == nums[index])
                return true;
        }
        return false;
    }
}