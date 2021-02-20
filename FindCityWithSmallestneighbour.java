class Solution {
    int dist[];
    boolean visited[];
    ArrayList<ArrayList<Pair>> adj;
    int count;
    class Pair
    {
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;//destination
            this.y=y;//distance
        }
    }
    ArrayList<Pair>aa;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        adj=new ArrayList<>();
        aa=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int act[]=new int[n];
        int indegree[]=new int[n];
        for(int a[]:edges)
        { if(a[2]<=distanceThreshold)
        {adj.get(a[0]).add(new Pair(a[1],a[2]));
            adj.get(a[1]).add(new Pair(a[0],a[2]));
            // indegree[a[0]]++;
            // indegree[a[1]]++;
        }
        }
        
        for(int i=0;i<n;i++)
        {  dist=new int[n];
         Arrays.fill(dist,Integer.MAX_VALUE);
         count=0;
          visited=new boolean[n];
         dist[i]=0;
            bfs(i,distanceThreshold);
       
        
        
         for(int kk=0;kk<n;kk++)
         {
             if(dist[kk]<=distanceThreshold)
             {
              count++;}
         }
         
        act[i]=count;
         //System.out.println(count);
        }
        int index=0;
      int min=Integer.MAX_VALUE;
         for(int i=0;i<n;i++)
         {
             if(act[i]<=min )
             {
                 min=act[i];
                 index=i;
             }
                 
         }
         

        
        return index;
     }
    
    public void bfs(int start,int distanceThreshold)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.y-b.y);
        pq.add(new Pair(start,0));
        int sum1=0;
                    //System.out.println("me"+start+"  "+"hu"+"okkkkkkkkk");

        while(!pq.isEmpty())
        {
            Pair pp=pq.poll();
            int d1=pp.x;
            int d2=pp.y;
            if(visited[d1])
                continue;
            visited[d1]=true;
            int max=0;
           
            for(int j=0;j<adj.get(d1).size();j++)
            {
                Pair p1=adj.get(d1).get(j);
                int d3=p1.x;
                int d4=p1.y;
                 //sum1=sum1+d4;
                if(!visited[d3] && (d2+d4)<=dist[d3])
                { //count++;
                    //dist[d3]=Math.max(d2+d4,dist[d3]);
                    //System.out.println(dist[d3]+"  ");
                    //max=Math.max(dist[d3],max);
                    dist[d3]=d2+d4;
                    pq.add(new Pair(d3,dist[d3]));
                    //dist[d3]=max;
                }
                
                
                
                
                
            }
            //dist[d1]=sum1;
        }
    }
    
    
    
    
    
    
    
}