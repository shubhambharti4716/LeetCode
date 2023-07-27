class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int bn = batteries.length;
        if(bn<n) return 0;
        long l=0, r=0;
        for(int b: batteries) r+=b;
        r/=n;
        long res=0;
        while(l<=r) {
            long mid = l+(r-l)/2;
            if(possible(n, batteries, mid)) {
                res=mid;
                l=mid+1;
            }else r=mid-1;
        }
        return res;
    }
    private boolean possible(int n, int[] batteries, long target) {
        long totalTarget = target*n;
        for(int b: batteries) totalTarget-=Math.min(target, b);
        return totalTarget<=0;
    }
}