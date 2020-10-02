package sword61;

class Solution {
    public boolean isStraight(int[] nums) {
        int []record = new int[14];
        int i;
        for(i = 0; i < 5;++i)
            ++record[nums[i]];
        for(i = 1;record[i]== 0 && i < 14 ; ++i)
            ;
        for(int num = 0; num < 5 && i + num <14; ++num){
            if(record[i + num] > 1)
                return false;
            if(record[i + num] == 0){
                if(record[0] == 0)
                    return false;
                else
                    --record[0];
            }
        }
        return true;

    }
}