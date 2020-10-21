package LC34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};
        int left = downK(nums,target);
        int right = uperK(nums,target);
        return new int[]{left,right};
    }

    public static int uperK(int[] a, int k){
        int l = 0;
        int r = a.length - 1;
        while(l < r){
            int mid = (l + r + 1) / 2;
            if(a[mid] <= k) {
                l = mid;
            }else{
                r= mid - 1;
            }
        }
        if(a[l] != k) return -1;
        return l;
    }
    public static int downK(int[] a, int key){
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            int mid = (low + high)/2;
            if (a[mid] < key)
                low = mid +1;
            else
                high = mid;
        }
        if (a[high] == key)
            return high;
        else
            return -1;
    }
}

