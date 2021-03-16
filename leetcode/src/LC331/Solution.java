package LC331;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isValidSerialization("1,#"));
    }
    public boolean isValidSerialization(String preorder) {
        List<String> tree = new ArrayList<>();
        char c;
        for (int i = 0; i < preorder.length(); i++) {
            if((c = preorder.charAt(i))!=','){
                if(c == '#')
                    tree.add("#");
                else {
                    StringBuilder s = new StringBuilder();
                    s.append(c);
                    while (i < preorder.length() - 1 && (c = preorder.charAt(++i))!=',' && c != '#' ){
                        s.append(preorder.charAt(i));
                    }
                    tree.add(s.toString());
                    continue;
                }
            }
        }
        return isTree(tree,0,tree.size()-1);


    }

    public boolean isTree(List<String> tree, int from, int to){
        int num = 0, leaf = 0,index = from + 1;
        String c = tree.get(from);
        if(from == to){
            if(c.equals("#"))
                return true;
            else
                return false;
        }
        if(c.equals("#"))
            return false;
        for(; index < to;++index){
            String tmp = tree.get(index);
            if(tmp.equals("#"))
                ++leaf;
            else
                ++num;
            if(leaf == num + 1)
                break;
        }
        if(index == to)
            return false;
        return isTree(tree,from + 1,index) && isTree(tree,index+1 ,to);
    }
}