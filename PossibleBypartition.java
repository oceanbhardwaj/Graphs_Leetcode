class Solution {
     ArrayList<ArrayList<Integer>> adj;
    boolean visited[];
    int color[];
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes.length==1 || dislikes.length==0 )
            return true;
         adj=new ArrayList<>();
        visited=new boolean[N+1];
        color=new int[N+1];
        //color[1]=1; //1 red,2 blue
        for(int i=0;i<=N;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int a[]:dislikes)
        {
            make_graph(a[0],a[1]);
        }
        for(int i=1;i<=N;i++)
        {
        if(!visited[i]){
           color[i]=1;
            dfs(i);
        }
        
        }
           // dfs(i);
        for(int a[]:dislikes)
        {
            if(color[a[0]]==color[a[1]])
                return false;
            
          }
        return true;
        
        
    }
    public void make_graph(int x,int y)
    {
        adj.get(x).add(y);
        adj.get(y).add(x);
    }
    public void dfs(int s)
    {
        if(visited[s])
            return;
        
        visited[s]=true;
        for(int i=0;i<adj.get(s).size();i++)
        {
            int d=adj.get(s).get(i);
            // if(visited[d])
            // {
            //     if(color[d]==color[s])
            //         return ;
            // }
            if(!visited[d])
            {
                if(color[s]==1)
                    color[d]=2;
                else
                    color[d]=1;
                dfs(d);
            }
        }
      
        
    }
}