package Interview89;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        DFS(n,n,new char[n*2],0,' ');
        return  res;
    }

    public void DFS(int left,int right,char[] s,int index,char c){
        if(left == 0 && right == 0){
            res.add(new String(s));
            return;
        }

        if(left == right){
            DFS(left-1,right ,s,index+1,s[index] = '(');
        }
        else{
            if(left == 0)
                DFS(left,right - 1,s,index+1,s[index] = ')');
            else {
                DFS(left,right - 1,s,index+1,s[index] = ')');
                DFS(left-1,right ,s,index+1,s[index] = '(');
            }
        }

    }
}