class Solution {
    public int findJudge(int N, int[][] trust) {
        int indegree[]=new int[N+1];
        int outdegree[]=new int[N+1];
        for(int a[]:trust)
        {
            indegree[a[1]]++;
            outdegree[a[0]]++;
        }
        int flag=-1;
        for(int i=1;i<=N;i++)
        {
            if(indegree[i]==N-1 && outdegree[i]==0)
            {flag=i;
             break;
            }
        }
        return flag;
    }
}