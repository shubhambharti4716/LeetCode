class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] c = s.toCharArray();
        boolean[] v = new boolean[128];
        int a=0, t=0;

        int l, r;
        for(char x='a'; x<='z'; x++){
            for(l=0; l<c.length && c[l]!=x; l++);
            if(l==c.length)continue;
            for(r=c.length-1; r>=0 && c[r]!=x; r--);
            if(l>=r)continue;

            Arrays.fill(v, false); t=0;
            for(int i=l+1; i<r; i++){
                if(!v[c[i]]){
                    v[c[i]]=true; t++;
                    if(t==26)break;
                }
            }
            a+=t;
        }
        return a;
    }
}