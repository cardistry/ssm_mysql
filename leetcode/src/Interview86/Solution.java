package Interview86;

import java.util.List;

class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        //得到盘子总数
        int n =A.size();
        func(n,A,B,C);
    }
    public void func(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        //当盘子都移动空了之后停止递归
        if(n<=0){
            return;
        }
        //将A上面的 n-1 个圆盘经由 C 移到 B
        func(n-1,A,C,B);
        //此时将 A 底下的那块最大的圆盘移到 C
        C.add(A.remove(A.size()-1));
        // 再将 B 上的 n-1 个圆盘经由A移到 C上
        func(n-1,B,A,C);
    }
}
