/*package whatever //do not write package name here */

import java.util.*;

class LongestPathInGraph {	
   static int Farthest=-1;
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int e=n-1;
	
		List<Integer> adj[]=new LinkedList[n+1];
		int dist[]=new int[n+1];
		Arrays.fill(dist,-1);
			
			for(int j=0;j<=n;j++)
			{
			    adj[j]=new LinkedList<>();
			}
			dist[0]=0;
		int root=-1;
		for(int i=0;i<e;i++)
		{
		    int x=sc.nextInt();
		    if(root==-1)
		    root=x;
		    
		    int y=sc.nextInt();
		    addEdge(adj,x,y);
		}

	
		int maxDist=bfs(adj,root,dist);
		Arrays.fill(dist,-1);
		
		maxDist=bfs(adj,Farthest,dist);
		System.out.println(maxDist);
	}
	static void addEdge(List<Integer> adj[],int x,int y)
	{
	    adj[x].add(y);
	    adj[y].add(x);
	}
	static int bfs(List<Integer> adj[],int root,int dist[])
	{
	    Queue<Integer> q=new LinkedList<>();
	    q.add(root);
	    dist[root]=0;
	    	
	    while(!q.isEmpty())
	    {
	        int p=q.poll();
	        Iterator<Integer> i=adj[p].listIterator();
	        while(i.hasNext())
	        {
	            int n1=i.next();
	            if(dist[n1]==-1)
	            {
	                dist[n1]=dist[p]+1;
	                q.add(n1);
	            }
	        }
	    }
	        int maxd=-1;
	        int node=-1;
	        for(int i1=1;i1<dist.length;i1++)
	        {
	            if(maxd<dist[i1])
	            {
	                maxd=dist[i1];
	                Farthest=i1;
	            }
	        }
	        
	    
	    return maxd;
	}
	
}