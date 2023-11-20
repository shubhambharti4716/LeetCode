class Solution {
    public int garbageCollection(String[]str, int[] arr) {
        	int g = -1, p =-1, m = -1;
	
	for (int i = 1; i < arr.length; i++) {
		
		arr[i] = arr[i]+arr[i-1];
		
	}
	int ans = 0;
	for (int i = 0; i < str.length; i++) {
		ans+=str[i].length();
		if(str[i].contains("G")) {
			g = i;
		}
		if(str[i].contains("P")) {
			p = i;
		}
		if(str[i].contains("M")) {
			m = i;
		}
	}
	
	if(g>=1)ans+=arr[g-1];
	if(p>=1)ans+=arr[p-1];
	if(m>=1)ans+=arr[m-1];
    return ans;
    }
}