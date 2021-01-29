class Solution {
    class Pair
    {
        int dest;
        int distance;
        int steps;
        Pair(int dest,int distance,int steps)
        {
            this.dest=dest;
            this.distance=distance;
            this.steps=steps;
        }
    }
    LinkedList<Pair> adj[];
    int d[];
    int ans=Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        adj=new LinkedList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new LinkedList<Pair>();
            
        }
        d=new int[n];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[src]=0;
        for(int a[]:flights)
        {
            make_graph(a[0],a[1],a[2]);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((o1,o2)->o1.distance-o2.distance);
        ans=Integer.MAX_VALUE;
        pq.add(new Pair(src,0,K+1));
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            int ss=p.dest;
            int ds=p.distance;
            int st=p.steps;
            if(ss==dst)
            {
               return ds;
            }
            if(st>0){
            for(int i=0;i<adj[ss].size();i++)
            {
                Pair p1=adj[ss].get(i);
                int ss1=p1.dest;
                int ds1=p1.distance;
               int newSteps=st-1;
                int new1=ds1+ds;
               // if(newSteps<=K+1 && new1<d[ss1])
               // {
                    d[ss1]=new1;
                    pq.add(new Pair(ss1,new1,newSteps));
               // }
            }
            }
            
        }
        
        return -1;
    }
    public void make_graph(int s,int d,int dest)
    {
        adj[s].add(new Pair(d,dest,0));
    }
}