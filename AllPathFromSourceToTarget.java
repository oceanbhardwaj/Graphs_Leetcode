class Solution {
     List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         res=new ArrayList<>();
        int n=graph.length;
       
        dfs(0,new ArrayList<Integer>(),graph,n);
        return res;
        
    }
    public void dfs(int start,ArrayList<Integer>a,int graph[][],int n )
    {
        if(start==n-1)
        { a.add(n-1);
            res.add(a);
            return;
        }
        a.add(start);
        for(int i:graph[start])
        {
            
                    dfs(i,new ArrayList<Integer>(a),graph,n);
               
        }
        
        
        
        
        
        
        
        
        
    }
}