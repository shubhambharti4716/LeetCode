//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
     int bfs(ArrayList<ArrayList<Integer>> adj,int V,boolean vis[],int level[],int X)
    {
        if(X>=V)
            return -1;
            
        //storing 0 or first vertex in x.
        int x = 0;
        
        //creating a queue and pushing x into it.
        Queue<Integer> q = new LinkedList<Integer>(); 
        q.add(x); 
    
        //marking x as visited and its level will be 0.
        level[x] = 0; 
        vis[x] = true; 
        
        while (q.size() > 0) 
        { 
            //storing first element of queue and popping it.
            x = q.peek(); 
            q.remove(); 
    
            //traversing adjacent vertices of current vertex.
            for (int i = 0; i < adj.get(x).size(); i++) 
            { 
                int b = adj.get(x).get(i); 
    
                //if vertex is not visited, we push it in the queue, mark 
                //it as visited and store its level.
                if (!vis[b])
                { 
                    q.add(b); 
                    level[b] = level[x] + 1; 
                    vis[b] = true; 
                } 
            } 
        } 
        //returning level of node X.
        return level[X];
    }
    
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) 
    {
        //arrays to store level of each node and to mark nodes as visited.
        int[] level = new int[V];

        // Initialize every element of the level array to -1
        for (int i = 0; i < V; i++) {
            level[i] = -1;
        }
        boolean vis[] = new boolean[V];
        
        return bfs(adj,V,vis,level,X);
    }
}