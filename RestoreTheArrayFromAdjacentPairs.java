class Solution {
      HashMap<Integer,List<Integer>> h;
    int arr[];
    Set<Integer> s;
    int index=0;
    public int[] restoreArray(int[][] adjacentPairs) {
     h =new HashMap<>();
        int n=adjacentPairs.length+1;
       arr=new int[n];
        for(int a[]:adjacentPairs)
        {
            make_graph(a[0],a[1]);
        }
        int start=0;
        for(int ele:h.keySet())
        {
            if(h.get(ele).size()==1)
            {
                start=ele;
                break;
            }
        }
        s=new HashSet<>();
        dfs(start);
        return arr;
        
        
    }
    public void make_graph(int x,int y)
    {
       h.putIfAbsent(x,new ArrayList<>());
        h.putIfAbsent(y,new ArrayList<>());
        h.get(x).add(y);
        h.get(y).add(x);
    }
    public void dfs(int start)
    {
        s.add(start);
        arr[index++]=start;
        List<Integer> l=h.get(start);
        for(int ele:l)
        {
            if(!s.contains(ele))
                dfs(ele);
        }
        
        
        
        
        
        
        
        
        
        
    }
}