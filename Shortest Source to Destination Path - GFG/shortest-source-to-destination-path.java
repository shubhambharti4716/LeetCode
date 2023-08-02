//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,0,0));
        boolean v[][]=new boolean[N][M];
        v[0][0]=true;
        int dx[]={0,0,-1,1},dy[]={-1,1,0,0};
        while(!q.isEmpty())
        {
            pair p=q.poll();
            if(p.a==X && p.b==Y)return p.c;
            for(int i=0;i<4;i++){
                int na=p.a+dx[i],nb=p.b+dy[i];
                if(na>=0 && na<N && nb>=0 && nb<M && !v[na][nb] && A[na][nb]==1){
                    q.add(new pair(na,nb,p.c+1));
                    v[na][nb]=true;
                }
            }
        }
        return -1;
    }
}
class pair
{
    int a,b,c;
    public pair(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
};