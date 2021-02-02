class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int indegree[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         adj=new ArrayList<>();
        int n=numCourses;
        indegree=new int[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int a[]:prerequisites)
        {
            make_graph(a[1],a[0]);
            indegree[a[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int c=q.poll();
            count++;
            for(int i=0;i<adj.get(c).size();i++)
            {
                int d=adj.get(c).get(i);
                indegree[d]--;
                if(indegree[d]==0)
                    q.add(d);
            }
        }
        if(count==n)
            return true;
        else 
            return false;
        
    }
    public void make_graph(int x,int y)
    {
        adj.get(x).add(y);
    }
}