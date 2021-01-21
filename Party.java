/*package whatever //do not write package name here */

import java.util.*;

 public class GFG {
   static  List<List<Integer>> adj;
 static boolean visited[];
 static int max=0;
static int level[];
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i]=sc.nextInt();
		}
		int countneg=0;
	List<List<Integer>> adj=new ArrayList<>();
	visited=new boolean[n+1];
	level=new int[n+1];
	for(int i=0;i<=n;i++)
		{
		    adj.add(new ArrayList<>());
		}
		for(int i=0;i<n;i++)
		{
		    if(arr[i]==-1)
		    make_graph(i+1,0,adj);
		    else
		    make_graph(i+1,arr[i],adj);
		    
		   
		}
	
		for(int i=0;i<n;i++)
		{
		    if(!visited[i])
		    dfs(i,visited,adj);
		}
		System.out.println(max);
	}
	public static void dfs(int i,boolean visited[],List<List<Integer>> adj)
	{
	    visited[i]=true;
	   List<Integer> l1=adj.get(i);
	   for(int j:l1)
	   {
	       if(!visited[j])
	       {
	           level[j]=level[i]+1;
	           max=Math.max(level[j],max);
	           dfs(j,visited,adj);
	       }
	   }
	}
	public static  void make_graph(int x,int y,List<List<Integer>> adj)
	{
	    //adj.get(x).add(y);
	    adj.get(y).add(x);
	}
}