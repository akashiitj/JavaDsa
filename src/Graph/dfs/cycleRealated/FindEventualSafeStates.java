package Graph.dfs.cycleRealated;

import java.util.*;

//https://leetcode.com/problems/find-eventual-safe-states/

class Solution {
    HashMap<Integer,ArrayList<Integer>> g;
    boolean[] vis,tempVis;
    HashSet<Integer> cycle;

    boolean dfs(int s){
        boolean ifCycle = false;
        vis[s]=true;
        tempVis[s]=true;
        for(int adj : g.get(s)){
            if(!vis[adj]){
                if(dfs(adj)){
                    ifCycle = true;
                    cycle.add(s);
                }
            }else if(tempVis[adj]||cycle.contains(adj)){
                ifCycle = true;
                cycle.add(s);
            }
        }
        tempVis[s]=false;
        return ifCycle;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        g = new HashMap<>();
        cycle = new HashSet<>();
        vis = new boolean[n];
        tempVis = new boolean[n];
        Arrays.fill(vis,false);
        Arrays.fill(tempVis,false);
        for (int i = 0; i < n; i++) {
            g.put(i,new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                g.get(i).add(graph[i][j]);
            }
        }
        for (int i = 0; i < n ; i++) {
            if(!vis[i]){
                dfs(i);
            }
        }

        for(int i=0;i<n;i++){
            if(!cycle.contains(i))
                ans.add(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
