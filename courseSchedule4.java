class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int matrix[][];
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        //bfs
        adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
       matrix=new int[n][n];
       List<Boolean> aa=new ArrayList<>();
        for(int a[]:prerequisites)
        {
            make_graph(a[0],a[1]);
        }
        for(int i=0;i<n;i++)
        {
            bfs(i);
        }
        for(int a[]:queries)
        {
            aa.add(matrix[a[0]][a[1]]==1);
        }
        return aa;
    }
    public void make_graph(int x,int y)
    {
        adj.get(x).add(y);
    }
    public void bfs(int start)
    {
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> s=new HashSet<>();
        
        q.add(start);
        s.add(start);
        int l=q.peek();
        while(!q.isEmpty())
        {
            int d=q.poll();
            for(int i=0;i<adj.get(d).size();i++)
            { int e=adj.get(d).get(i);
                if(!s.contains(e))
                {
                matrix[l][e]=1;
                q.add(e);
                s.add(e);}
            }
        }
    }
}