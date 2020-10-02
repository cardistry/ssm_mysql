package sword51;
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0, nums.length-1);
    }
    public int mergeSort(int nums[],int start,int end){
        if(end - start < 1)
            return 0;
        int mid = start + (end - start) / 2;
        int left = mergeSort(nums,start,mid);
        int right = mergeSort(nums,mid +1,end);
        return left + right + merge(nums,start,mid,mid + 1,end);
    }
    int merge(int nums[],int lstart,int lend,int rstart,int rend){
        int len = lend - lstart + 1;
        int i,j,count;
        count = 0;
        i = 0;
        j = rstart;
        int[] tmp = new int[len];
        System.arraycopy(nums,lstart,tmp,0,len);
        while (i < len && j < rend + 1){
            while (j < rend + 1 && nums[j] < tmp[i])
               nums[lstart++] = nums[j++];
            count += j -  rstart;
            nums[lstart++] = tmp[i++];
         }
        while (i < len){
            nums[lstart++] = tmp[i++];
            count += j - rstart;
        }
        while (j < rend + 1)
            nums[lstart++] = nums[j++];
        return count;
    }
}