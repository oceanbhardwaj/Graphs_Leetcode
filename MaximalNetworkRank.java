/*class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int a[]:roads)
        {
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        int max=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                HashSet<Integer> h1=new HashSet<>();
                HashSet<Integer> h2=new HashSet<>();
                for(int ele:adj.get(i))
                {
                    h1.add(ele);
                }
                 for(int ele:adj.get(j))
                {
                    h2.add(ele);
                }
                if(h1.contains(j) && h2.contains(i))
                {
                    max=Math.max(h1.size()+h2.size()-1,max);
                }
                else
                    max=Math.max(h1.size()+h2.size(),max);
                
                
                
                
                
                
                
            }
        }
        return max;
    }
}*/


class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int indegree[]=new int[n];
        int connected[][]=new int[n][n];
        for(int a[]:roads)
        {
            indegree[a[0]]++;
            indegree[a[1]]++;
            connected[a[0]][a[1]]=1;
            connected[a[1]][a[0]]=1;
        }
        int max=0;
       for(int i=0;i<n;i++)
       {
           for(int j=i+1;j<n;j++)
           {
               max=Math.max(indegree[i]+indegree[j]-connected[i][j],max);
           }
       }
       return max; 
        
        
        
        
    }
}