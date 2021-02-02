/*class Solution {
    ArrayList<ArrayList<Integer>>adj;
   int indegree[];
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj=new ArrayList<>();
        int n=numCourses;
        int arr[]=new int[n];
        indegree=new int[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int a[]:prerequisites)
        {
            make_graph(a[1],a[0]);
            indegree[a[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        int index=0;
        int count=0;
        while(!q.isEmpty())
        {
            count++;
            int d=q.poll();
            arr[index++]=d;
            for(int i=0;i<adj.get(d).size();i++)
            {
                int c=adj.get(d).get(i);
                indegree[c]--;
                if(indegree[c]==0)
                    q.add(c);
            }
        }
        if(count==n)
            return arr;
        else
            return new int[]{};
        
        
        
    }
    public void make_graph(int x,int y)
    {
        adj.get(x).add(y);
    }
}*/

//////////////////////////////////////////////////////////////////////////////////DFS//////////////////////////////////////////////////////////////////

class Solution {
    ArrayList<ArrayList<Integer>>adj;
   boolean visited[];
    boolean rs[];
    Stack<Integer>s;
    int arr[];
    int index=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj=new ArrayList<>();
        int n=numCourses;
         arr=new int[n];
        rs=new boolean[n];
        visited=new boolean[n];
        s=new Stack<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int a[]:prerequisites)
        {
            make_graph(a[1],a[0]);
           
        }
        int flag=0;
     for(int i=0;i<n;i++)
     {
         if(dfs(i))
         {
             flag=1;//false;
                 break;
         }
     }
        while(!s.isEmpty())
        {
            arr[index++]=s.pop();
        }
        if(flag==1)
            return new int[]{};
        else
            return arr;
        
        
        
    }
    
    public boolean dfs(int start)
    {
        if(rs[start])
            return true;
        if(visited[start])
            return false;
        visited[start]=true;
        rs[start]=true;
        ArrayList<Integer> aa=adj.get(start);
        for(int ele:aa)
        {
           if(dfs(ele))
               return true;
        }
        rs[start]=false;
        s.push(start);
        return false;
    }
    
    
    
    
    
    
    
    
    public void make_graph(int x,int y)
    {
        adj.get(x).add(y);
    }
}