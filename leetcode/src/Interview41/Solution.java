package Interview41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    boolean [] visited;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if(start == target)
            return true;
        visited = new boolean[n];
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();

        for(int i=0;i<n;i++){
            ArrayList list = new ArrayList<Integer>();
            map.put(i,list);
        }

        for(int i=0;i<graph.length;i++){
            map.get(graph[i][0]).add(graph[i][1]);
        }

        dfs(map,start);
        return visited[start] && visited[target];
    }

    void dfs(Map<Integer,ArrayList<Integer>> map,int start){
        visited[start] = true;
        for(int p:map.get(start))
        {
            if(!visited[p]){
                dfs(map,p);
            }
        }
        return ;
    }
}

