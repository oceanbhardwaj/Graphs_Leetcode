class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> aa=new ArrayList<>();
        int indegree[]=new int[n];
        for(List l:edges)
        {
            indegree[(int)l.get(1)]++;
        }
        for(int i=0;i<n;i++)
        { if(indegree[i]==0)
                aa.add(i);}
        return aa;
    }
}