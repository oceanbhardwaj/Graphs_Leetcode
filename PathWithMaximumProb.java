class Solution {
   
    class Pair
    {
        
        int x; //edge
        double y; //prob
    Pair(int x,double y)
    {
        this.x=x;
        this.y=y;
    }
        
    
    }
     boolean visited[];
    double dist[];
    ArrayList<ArrayList<Pair>> adj;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        adj=new ArrayList<>();
        visited=new boolean[n];
        dist=new double[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int count=0;
        for(int a[]:edges)
        {
            
            adj.get(a[0]).add(new Pair(a[1],succProb[count]));
        adj.get(a[1]).add(new Pair(a[0],succProb[count]));
            count++;
        }
        
       
       Arrays.fill(dist,Integer.MIN_VALUE);
        dist[start]=0;
        bfs(start);
        return dist[end]==Integer.MIN_VALUE?0.0:dist[end];
        
        
        
    }
    public void bfs(int start)
    {
      
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> (((Double) b.y).compareTo((Double) a.y)));
        pq.add(new Pair(start,(double)1));
        while(!pq.isEmpty())
        {
            Pair pp=pq.poll();
            int edge=pp.x;
            double prob=pp.y;
            if(visited[edge])
                continue;
            visited[edge]=true;
            for(int i=0;i<adj.get(edge).size();i++)
            {
               Pair d=adj.get(edge).get(i);
                int d1=d.x;
                double d2=d.y;
                double act=prob*d2;
                //System.out.println(act);
                if(!visited[d1] && act>dist[d1]  )
                {
                    //System.out.println("jbhef");
                    dist[d1]=act;
                    pq.add(new Pair(d1,act));
                }
                
            }
            
            
            
            
            
            
            
            
            
            
            
        }
    }
    
    
    
    
    
    
    
   
}