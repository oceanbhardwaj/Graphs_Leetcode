import java.util.*;


class Pair{                                                                      
	int source;
	int dest;
	int weight;
	Pair(int source,int dest,int weight)
	{
		this.source=source;
		this.dest=dest;
		this.weight=weight;
	}
}
class Algo_Kruskal
{ static int sum=0;
	 static int parent[];
	public static void main(String[] args) {
		int v=9;
		
		 parent=new int[v];
		for(int i=0;i<v;i++)
		{
			parent[i]=i;
		}

		Comparator co=new Comparator<Pair>()
		{
			public int compare(Pair p1,Pair p2)
			{
                int d1=p1.weight;
                int d2=p2.weight;
                return d1-d2;
			}

		};
		PriorityQueue<Pair> pq=new PriorityQueue<>(co);
		// pq.add(new Pair(7,6,1)); //s,dest,w
		// pq.add(new Pair(8,2,2));
		// pq.add(new Pair(6,5,2));
		// pq.add(new Pair(0,1,4));
		// pq.add(new Pair(2,5,4));
		// pq.add(new Pair(8,6,6));
		// pq.add(new Pair(2,3,7));
		// pq.add(new Pair(7,8,7));
		// pq.add(new Pair(0,7,8));
		// pq.add(new Pair(1,2,8));
		// pq.add(new Pair(3,4,9));
		// pq.add(new Pair(5,4,10));
		// pq.add(new Pair(1,7,11));
		// pq.add(new Pair(3,5,14));
		pq.add(new Pair(1,2,100));
		pq.add(new Pair(2,4,200));
		pq.add(new Pair(4,3,50));
		pq.add(new Pair(3,1,30));
		while(!pq.isEmpty())
		{
			Pair pp=pq.poll();
			union(pp);
		}
		System.out.println(sum);

	}
	public static void union(Pair p)
	{
     int s=p.source;
     int d=p.dest;
     int w=p.weight;
     int fx=find_parent(s);
     int fy=find_parent(d);
     if(fx==fy)
     	return;
     sum=sum+w;
     parent[fy]=fx;

	}
	public static int find_parent(int node)
	{
		if(parent[node]==node)
			return node;
		int p=find_parent(parent[node]);
		return parent[node]=p;
	}
}