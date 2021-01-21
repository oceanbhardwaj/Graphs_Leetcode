/*package whatever //do not write package name here */

import java.util.*;

 public class NewYearTransportation {
   static boolean visited[];
   static LinkedList<Integer> adj[];
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int t=sc.nextInt();
	    int arr[]=new int[n];
	    for(int i=0;i<n-1;i++)
	    {
	        arr[i]=sc.nextInt();
	    }
	   adj=new LinkedList[n];
	    for(int i=0;i<n;i++)
	    {
	        adj[i]=new LinkedList<>();
	    }
		for(int i=0;i<n;i++)
		{
		    makeGraph(i,i+arr[i]);
		}
	 visited=new boolean[n];
		dfs(0,visited,adj);
		if(visited[t-1])
	System.out.println("YES");
	else
		System.out.println("NO");
		
	}
	public static void dfs(int i,boolean visited[],LinkedList<Integer> adj[] )
	{
	    visited[i]=true;
	   // System.out.println(i);
	    Iterator<Integer> i1=adj[i].listIterator();
	    while(i1.hasNext())
	    {
	        int n=i1.next();
	        if(!visited[n])
	        dfs(n,visited,adj);
	    }
	    
	}
	
	
	
	
	public static void makeGraph(int x,int y)
	{
	    adj[x].add(y);
	    
	}
}