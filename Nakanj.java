/*package whatever //do not write package name here */

import java.util.*;

class Nakanj {
   static class Pair
    {
        int x;
        int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y; 
        }
    }
	public static void main (String[] args) {
	Scanner sc=new Scanner(System.in);
	HashMap<Character,Integer> h=new HashMap<>();
	h.put('a',1);
	h.put('b',2);
	h.put('c',3);
	h.put('d',4);
	h.put('e',5);
	h.put('f',6);
	h.put('g',7);
	h.put('h',8);
	int t=sc.nextInt();
	int arr[]={-2,-2,-1,1,2,2,1,-1};
	int brr[]={-1,1,2,2,1,-1,-2,-2};
	for(int i=0;i<t;i++)
	{
	    String s1=sc.next();
	    String s2=sc.next();
	    boolean state[][]=new boolean[9][9];
	    int x1=h.get(s1.charAt(0)); //source
	    int y1=Integer.parseInt(s1.charAt(1)+""); //source
	     int x2=h.get(s2.charAt(0));//destination
	    int y2=Integer.parseInt(s2.charAt(1)+""); //destination
	    int dist[][]=new int[9][9];
	    
	   Queue<Pair> q=new LinkedList<>();
	    q.add(new Pair(x1,y1));
	    state[x1][y1]=true;
	   
	    while(!q.isEmpty())
	    {
	        Pair p1=q.poll();
	        int a=p1.x;
	        int b=p1.y;
	        if(a==x2 && b==y2)
	        {
	            System.out.println(dist[a][b]);
	            break;
	        }
	        for(int j=0;j<8;j++)
	        {
	            int a1=a+arr[j];
	            int b1=b+brr[j];
	            if(a1<=8 && a1>=1 && b1>=1 && b1<=8 && state[a1][b1]==false)
	            {
	                q.add(new Pair(a1,b1));
	                state[a1][b1]=true;
	                dist[a1][b1]=dist[a][b]+1;
	            }
	        }
	       // System.out.println(dist[x2][y2]);
	        
	    }
	    }
	    
	}
}