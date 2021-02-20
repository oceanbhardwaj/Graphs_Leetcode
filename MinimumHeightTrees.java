/*class Solution {
    int count=0;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>aa =new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int a[]:edges)
        {
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        int rootHeight[]=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            count=0;
            boolean visited[]=new boolean[n];
            bfs(i,adj,visited);
            
            rootHeight[i]=count;
            //System.out.println(count);
            min=Math.min(min,count);
        }
        for(int i=0;i<n;i++)
        {
            if(rootHeight[i]==min)
                aa.add(i);
        }
       return aa; 
    }
    
    public void bfs(int start,ArrayList<ArrayList<Integer>> adj,boolean visited[])
    {
        Queue<Integer> pq=new LinkedList<>();
        pq.add(start);
        visited[start]=true;
        while(!pq.isEmpty())
        {
            
            int size=pq.size();
            count++;
            for(int j=0;j<size;j++)
            {
                int d=pq.poll();
                // if(visited[d])
                //    continue;
               // visited[d]=true;
                for(int k=0;k<adj.get(d).size();k++)
                {
                    int e=adj.get(d).get(k);
                    if(!visited[e])
                    { visited[e]=true;
                        pq.add(e);
                    }
                }
            }
            
            
        }
        
        //System.out.println(count);
        
        
        
    }
}*/

///////////////////////////////////////////////
class Solution {
    int count=0;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>aa =new ArrayList<>();
        int indegree[]=new int[n];
        if(n==1)
        {
            aa.add(0);
            return aa;
        }
            
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int a[]:edges)
        {
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
            indegree[a[0]]++;
            indegree[a[1]]++;
        }
        Queue<Integer> pq=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==1)
                pq.add(i);
        }
        int N=n;
        while(n>2)
        {
            int size=pq.size();
            n=n-size;
            for(int i=0;i<size;i++)
            {
                int d=pq.poll();
                for(int j=0;j<adj.get(d).size();j++)
                {
                    int d1=adj.get(d).get(j);
                    indegree[d1]--;
                    if(indegree[d1]==1)
                        pq.add(d1);
                }
            }
        }
         int min=Integer.MAX_VALUE;
        int rootHeight[]=new int[N];
       
        while(!pq.isEmpty())
        {
            int dd=pq.poll();
            
            count=0;
           
            boolean visited[]=new boolean[N];
            bfs(dd,adj,visited);
            rootHeight[dd]=count;
            min=Math.min(count,min);
            
            
            
            
        }
        for(int i=0;i<N;i++)
        {
            if(rootHeight[i]==min)
                aa.add(i);
        }
       return aa;
    }
       
    
    public void bfs(int start,ArrayList<ArrayList<Integer>> adj,boolean visited[])
    {
        Queue<Integer> pq1=new LinkedList<>();
        pq1.add(start);
        visited[start]=true;
        while(!pq1.isEmpty())
        {
            
            int size1=pq1.size();
            count++;
            for(int j=0;j<size1;j++)
            {
                int d11=pq1.poll();
               
                for(int k=0;k<adj.get(d11).size();k++)
                {
                    int e=adj.get(d11).get(k);
                    if(!visited[e])
                    { visited[e]=true;
                        pq1.add(e);
                    }
                }
            }
            
            
        }
        
       
        
        
        
    }
}