package LC118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j <= i ; j++) {
                if(j == 0 || j == i)
                    res.get(i).add(1);
                else{
                    int a = res.get(i-1).get(j-1);
                    int b = res.get(i-1).get(j);
                    res.get(i).add(a+b);
                }


            }
        }
        return res;

    }
}