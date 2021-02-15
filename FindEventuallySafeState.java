class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> aa=new ArrayList<>();
        boolean visited[]=new boolean[n];
         boolean visitedRR[]=new boolean[n];
        for(int i=0;i<n;i++)
        { 
            if(!dfs(i,visited,graph,visitedRR))
            {
                aa.add(i);
            }
                
        }
        return aa;
        
        
    }
    public boolean dfs(int i,boolean visited[],int graph[][],boolean visitedRR[])
    {
        if(visitedRR[i])
            return true;
        if(visited[i])
			return false;
            visitedRR[i]=true;
        visited[i]=true;
        for(int edge:graph[i])
        {
            
            if(dfs(edge,visited,graph,visitedRR))
                return true;
        }
        visitedRR[i]=false;
        return false;
    }
}