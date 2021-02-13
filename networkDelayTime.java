class Solution {
    class Pair
    {
        int dest;
        int w;
        Pair(int dest,int w)
        {
            this.dest=dest;
            this.w=w;
        }
    }
    ArrayList<ArrayList<Pair> >adj;
    public int networkDelayTime(int[][] times, int n, int k) {
        adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int a[]:times)
        {
            make_graph(a[0],a[1],a[2]);
        }
        int distance[]=new int[n+1];
        boolean visited[]=new boolean[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((o1,o2)->o1.w-o2.w);
        pq.add(new Pair(k,0)); //dest,w
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            int ss=p.dest;
            int ww=p.w;
            if(visited[ss])
                continue;
            visited[ss]=true;
            for(int i=0;i<adj.get(ss).size();i++)
            {
                Pair p1=adj.get(ss).get(i);
                int ss1=p1.dest;
                int ww1=p1.w;
                int act=ww1+ww;
                if(!visited[ss1] && act<distance[ss1])
                {
                    distance[ss1]=act;
                    pq.add(new Pair(ss1,act));
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++)
        { 
            if(distance[i]!=Integer.MAX_VALUE)
            {
                max=Math.max(distance[i],max);
            }
            else if(distance[i]==Integer.MAX_VALUE)
                return -1;
        }
        return max;
        
    }
    public void make_graph(int x,int y,int w)
    {
        adj.get(x).add(new Pair(y,w));
    }
}