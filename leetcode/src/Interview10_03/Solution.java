package Interview10_03;

class Solution {
    public static void main(String[] args) {
        new Solution().search(new int[]{4,5,6,7,0,1,2},0);
    }
    public int search(int[] arr, int target) {
        int i;
        for (i = 0; i < arr.length - 1 && arr[i] < arr[i+1] ; i++);
        int res = biarysearch(arr,0,i,target);
        if(res == -1)
            res = biarysearch(arr,i+1,arr.length - 1,target);
        return res;


    }
    public int biarysearch(int []arr,int low,int high,int target){
        while (low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        if(high < arr.length -1 &&  arr[high + 1] == target)
            return high + 1;
        return  -1;
    }
}