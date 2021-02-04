class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        //row
        int arr[]=new int[n];
        int brr[]=new int[m];
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<m;j++)
            {
            
                if(grid[i][j]==1)
                count++;
             }
            arr[i]=count;
            
        
          }
        //column
        for(int i=0;i<m;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
            
                if(grid[j][i]==1)
                count++;
             }
            brr[i]=count;
            
        
          }
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && (arr[i]>1 || brr[j]>1))
                    count++;
            }
        }
        
        return count;
        
        
        
        
}
}