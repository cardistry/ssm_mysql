package RedundantConnectionII685;

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int father ,son,cura,curb;
        father = son = cura = curb = 0;
        int flag = 0;
        int len = edges.length;
        int [] res = new int[2];
        int record[] = new int[len+1];
        int recordfather[] = new int[len+1];
        for(int i = 0; i < len; ++i){
            son = edges[i][1];
            record[son] += 1;
            if(record[son] > 1) {
                flag = 1;
                cura = edges[i][0];
                curb = recordfather[son];
                break;
            }
            recordfather[son] = edges[i][0];
        }
       if(flag == 1){
           int count = 0;
           for(int i = 0; i < len; ++i){
               if(edges[i][1] == cura)
                   count += 1;
           }
           res[0] = (count == 0) ? curb : cura;
           res[1] = son;
       }
       else{
           for(int i = 0; i < len + 1; ++i)
               record[i] = i;
           int i = 0;
           for( i = 0;i < len;++i){
               son = edges[i][1];
               father = edges[i][0];
               int tmp = record[son];
               while (record[son] != father){
                   record[son] = father;
                   father = record[father];
               }
               if(father == tmp)
                   break;
           }
           res[0] = edges[i][0];
           res[1] = edges[i][1];
       }
       return res;
    }
}