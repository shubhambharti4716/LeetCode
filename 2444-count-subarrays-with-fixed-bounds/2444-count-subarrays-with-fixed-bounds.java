class Solution 
{
    public long countSubarrays(int[] a, int m, int M) 
    {
        int x=-1;
        int y=-1;
        int l=0;
        long c=0;
        for(int i=0; i<a.length; i++)
        {
            if(a[i]<m || a[i]>M)
            {
                l = i+1;
                x = i;
                y = i;
                continue;
            }
            if(a[i] == m)
                x = i;
            if(a[i] == M)
                y = i;
            c+= (i-l+1) - (i - (Math.min(x,y)+1)+1);
        }
        return c;
    }
}