class GraphCycle
{
	int n;
	int parent[];
	GraphCycle(int n)
	{
		this.n=n;
		parent=new int[n];
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
		}
	}
	void union(int x,int y)
	{
		int fx=find_parent(x);
		int fy=find_parent(y);
		if(fx==fy)
			System.out.println("cycle is present");
		
		parent[fy]=fx;
	}
	public int find_parent(int node)
	{
		if(parent[node]==node)
			return node;
		int p1=find_parent(parent[node]);
		return parent[node]=p1;
	}

}




class Cycle
{
	public static void main(String[] args) 
	{ int n=5;
		GraphCycle obj=new GraphCycle(n);
		obj.union(1,2);
		obj.union(2,3);
		obj.union(3,4);
		obj.union(4,1);

	}
}




////////////////////////////////////////////////////////DFS/////////////////////////////////////////////////o(v+e)////////////////////////////////////////
import java.util.*;
class CycleGraph
{

int v;
List<List<Integer>> adj;
CycleGraph(int V)
{
 v=V;
 adj=new ArrayList<>();
 for(int i=0;i<v;i++)
 {
 	adj.add(new LinkedList<>());
 }
 

}
public boolean isCyclic()
	{
		boolean visited[]=new boolean[v];
		boolean recursionStack[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(cycleUtil(i,visited,recursionStack,adj))
				return true;
		}
		return false;
	}
	public boolean cycleUtil(int i,boolean visited[],boolean recursionStack[],List<List<Integer>> adj)
	{
		if(recursionStack[i])
			return true;
		if(visited[i])
			return false;
		visited[i]=true;
		recursionStack[i]=true;
		List<Integer> l1=adj.get(i);
		for(int j:l1)
		{
        if(cycleUtil(j,visited,recursionStack,adj))
        	return true;
		}

      recursionStack[i]=false;
      return false;
  }

public void makeGraph(int x,int y)
 {
 	adj.get(x).add(y);
 	
 }
	

}
class Tuples
{
	public static void main(String[] args) 
	{
		int V=4;
		CycleGraph c=new CycleGraph(V);
		c.makeGraph(0,1);
		c.makeGraph(0,2);
		c.makeGraph(1,2);
		c.makeGraph(2,0);
		c.makeGraph(2,3);
		c.makeGraph(3,3);
		if(c.isCyclic())
			System.out.println("cycle is present!!!!!!!!!!!!!");
		else
			System.out.println("cycle is not present!!!!!!!!!!!!!");
		

		


	}

}


