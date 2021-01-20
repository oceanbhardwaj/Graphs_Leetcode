class Disjoin
{
	int parent[];
	int n;
	Disjoin(int n)
	{
		this.n=n;
		parent=new int[n];
		for(int i=0;i<n;i++)    //everybody has its own parent in starting 
	{
		parent[i]=i;
	}

	}
	


	//union
	void union(int x,int y)
	{
	  int fx=find_parent(x);
	  int fy=find_parent(y);
	  if(fx==fy)
	  	return;
	  parent[fy]=fx;
	}

	//find parent
	public int find_parent(int node)
	{
		if(parent[node]==node)
			return node;
		int parent1=find_parent(parent[node]);
		return parent[node]=parent1;
	}
}
class DisjointSet
{
   public static void main(String[] args) {
   	int n=5;
   	Disjoin obj=new Disjoin(n);
   	obj.union(0,2);
   	obj.union(4,2);
   	obj.union(3,1);
  if(obj.find_parent(4)==obj.find_parent(0))
   		System.out.println("Yes");
   	else 
   		System.out.println("No");
	if(obj.find_parent(1)==obj.find_parent(3))
   		System.out.println("Yes");
   	else 
   		System.out.println("No");


   }
}