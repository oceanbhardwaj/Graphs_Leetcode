class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean visited[]=new boolean[n];
        int indegree[]=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            if(leftChild[i]!=-1)
            {
                adj.get(i).add(leftChild[i]);
                indegree[leftChild[i]]++;
            }
             if(rightChild[i]!=-1)
             {adj.get(i).add(rightChild[i]);
              indegree[rightChild[i]]++;
             }
            
            
        }
        int index=-1;
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                index=i;
                break;
            }
        }
        if(index==-1)
            return false;
        Queue<Integer> pq=new LinkedList<>();
        pq.add(index);
        visited[index]=true;
        while(!pq.isEmpty())
        {
            int d=pq.poll();
            // if(visited[d])
            //     return false;
            // visited[d]=true;
            
            for(int i=0;i<adj.get(d).size();i++)
            {
                int e=adj.get(d).get(i);
                if(!visited[e])
                {
                    pq.add(e);
                    visited[e]=true;
                }
                else
                    return false;
            }
            
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
                return false;
        }
        return true;
        
        
    }
}