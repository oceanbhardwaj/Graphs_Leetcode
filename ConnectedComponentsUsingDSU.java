import java.util.*;
class ConnectedComponentsUsingDSU
{  static int parent[];
	public static void main(String[] args) 
	{
		int v=7;
		 parent=new int[v];
		for(int i=0;i<v;i++) //number of unique parents is connected components
		{
			parent[i]=i;
		}
		union(0,1);
		union(1,2);
		
		union(3,4);
		union(5,6);

		int count=0;
		for(int i=0;i<v;i++)
			{
				if(parent[i]==i)
					count++;
			}
		System.out.println(count);
	}
	public static void union(int x,int y)
	{
		int fx=find_parent(x);
		int fy=find_parent(y);
		if(fx==fy)
			return ;
		parent[fy]=fx;
	}
	public static int find_parent(int node)
	{
		if(parent[node]==node)
			return node;
		int p1=find_parent(parent[node]);
		return parent[node]=p1;
	}
}