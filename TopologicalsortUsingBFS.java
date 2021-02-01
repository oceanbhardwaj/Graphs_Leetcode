//kahn algo
import java.util.*;
class TopologicalsortUsingBFS
{
	static ArrayList<ArrayList<Integer>> adj;
	static int indegree[];
	public static void main(String[] args) {
		int v=6;
		adj=new ArrayList<>();
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<>());
		}
		indegree=new int[6];
	    make_graph(5,2);
	    make_graph(2,5);
		make_graph(5,0);
		make_graph(4,0);
		make_graph(4,1);
		make_graph(2,3);
		make_graph(3,1);
	Queue<Integer> q=new LinkedList<Integer>();
	for(int i=0;i<v;i++)
	{
		if(indegree[i]==0)
			q.add(i);
	}
	while(!q.isEmpty())
	{
		int s=q.poll();
		System.out.print(s+"   ");
		for(int i=0;i<adj.get(s).size();i++)
		{
			int d=adj.get(s).get(i);
			indegree[d]--;
			if(indegree[d]==0)
				q.add(d);


		}
	}


	}
	public  static void  make_graph(int x,int y)

	{
		indegree[y]++;
		adj.get(x).add(y);
	}
}