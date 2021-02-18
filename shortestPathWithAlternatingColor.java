class Solution {
   
    
    class Pair
    {
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x; //edge
            
            this.y=y;//color
        }
        
    }
    int res[];
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
     
        ArrayList<ArrayList<Integer>> bluelist=new ArrayList<>();
        ArrayList<ArrayList<Integer>> redlist=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            bluelist.add(new ArrayList<>());
            redlist.add(new ArrayList<>());
        }
        for(int a[]:blue_edges)
        {
           bluelist.get(a[0]).add(a[1]);
        }
        for(int a[]:red_edges)
        {
            redlist.get(a[0]).add(a[1]);
        }
         res=new int[n];
        for(int i=0;i<n;i++)
        {
            res[i]=-1;
        }
        
        
        
        bfs(bluelist,redlist,n);
        
        return res;
        
        
        
        
        
    }
    public int bfs(ArrayList<ArrayList<Integer>> bluelist,ArrayList<ArrayList<Integer>> redlist,int n)
    {
        Queue<Pair> pq=new LinkedList<>();
        pq.add(new Pair(0,0));
        pq.add(new Pair(0,1));
        boolean visited[][]=new boolean[n][2];
        int step=0;
        while(!pq.isEmpty())
        {
            int size=pq.size();
            
            for(int j=0;j<size;j++)
            {
                Pair pp=pq.poll();
                int curedge=pp.x;
                int curcolor=pp.y;
                ArrayList<Integer> red=redlist.get(curedge);
                ArrayList<Integer> blue=bluelist.get(curedge);
                visited[curedge][curcolor]=true;
                 
               
                if(res[curedge]==-1)
                    res[curedge]=step;
                else 
                    res[curedge]=Math.min(res[curedge],step);
                
                //0 red 1 blue
                if(curcolor==1)//blue
                {
                    for(int neighbour:red)
                    {
                        if(!visited[neighbour][0])
                        {
                            pq.add(new Pair(neighbour,0));
                        }
                    }
                }
                else if(curcolor==0)//blue
                {
                    for(int neighbour:blue)
                    {
                        if(!visited[neighbour][1])
                        {
                            pq.add(new Pair(neighbour,1));
                        }
                    }
                }
                
                
                
                
            }
            step++;
        }
        
        
        
        
        
        
        
        
        
        
        
        
       return -1; 
        
        
        
    }
    
    
}