class Solution {
    class Pair
    {
      int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean state[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!state[i][j] && grid[i][j]=='1')
                {
                    bfs(i,j,grid,state,n,m);
                        count++;
                }
            }
        }
        return count;
    }
    public void bfs(int i,int j,char grid[][],boolean state[][],int n,int m)
    {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        state[i][j]=true;
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int a=p.x;
            int b=p.y;  //a-1,b  a,b+1    a+1,b     a,b-1
            if(a-1>=0 && b<m && !state[a-1][b] && grid[a-1][b]=='1')
            {q.add(new Pair(a-1,b));
             state[a-1][b]=true;}
             if(a<n && b+1<m && !state[a][b+1] &&  grid[a][b+1]=='1')
               {q.add(new Pair(a,b+1));
             state[a][b+1]=true;}
             if(a+1<n && b<m && !state[a+1][b] && grid[a+1][b]=='1')
                {q.add(new Pair(a+1,b));
             state[a+1][b]=true;}
             if(a<n && b-1>=0 && !state[a][b-1] && grid[a][b-1]=='1')
               {q.add(new Pair(a,b-1));
             state[a][b-1]=true;}
                
            
        }
    }
}