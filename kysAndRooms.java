class Solution {
    boolean visited[];
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        visited=new boolean[n];
        //visited[0]=true;
      
        dfs(0,rooms);
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
                return false;
                
        }
        
        return true;
        
        
        }
    public void dfs(int ele,List<List<Integer>> rooms)
    {
        if(visited[ele])
            return;
        visited[ele]=true;
        List<Integer> l1=rooms.get(ele);
        for(int ee:l1)
        {
            if(!visited[ee])
                dfs(ee,rooms);
        }
    }
}