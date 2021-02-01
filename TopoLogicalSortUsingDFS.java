import java.util.*;
class TopoLogicalSortUsingDFS
{
	 static ArrayList<ArrayList<Integer>> adj;
	static boolean visited[];
	static Stack<Integer> s;
	public static void main(String[] args) {
		adj=new ArrayList<>();
		int v=6;
		 visited=new boolean[v];
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<>());
		}
		s=new Stack<>();
		make_graph(5,2);
		make_graph(5,0);
		make_graph(4,0);
		make_graph(4,1);
		make_graph(2,3);
		make_graph(3,1);
		// make_graph(0,1);
		// make_graph(1,2);
		// make_graph(0,2);
		// make_graph(3,2);
	    for(int i=0;i<v;i++)
	    {
         if(!visited[i])
         	dfs(i);
	    }
	    while(!s.isEmpty())
	    {
	    	System.out.println(s.pop()+ "    ");
	    }


	}
	 public static void make_graph(int x,int y)
	{
		adj.get(x).add(y);
	}
	public  static void dfs(int i)
	{
		visited[i]=true;
		ArrayList<Integer> aa=adj.get(i);
		for(int ele:aa)
		{
			if(!visited[ele])
				dfs(ele);
		}
		s.push(i);
	}
}