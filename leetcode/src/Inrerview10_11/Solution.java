package Inrerview10_11;

class Solution {
    boolean flag = false;   //true 顺序 false 逆序
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1;  i++) {
             if(flag){
                 if(nums[i] < nums[i+1])
                     swap(nums,i,i+1);
             }
             else {
                 if(nums[i] > nums[i+1])
                     swap(nums,i,i+1);
             }
            flag = !flag;
        }
    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}