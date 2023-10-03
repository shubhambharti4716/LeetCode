//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution{
    public:
    string colName (long long int n)
    {
    	string res = ""; // to store the result
    
    	int temp;
    	while (n) // while n > 0
    	{
    	    n--;
    		temp = n % 26;
    		res += ('A' + temp);
    		n /= 26;
    	}
    
    	// res contains the answer but in reverse.
    	// hence, reversing it
    	reverse (res.begin (), res.end ());
    	return res;
    }
};

//{ Driver Code Starts.
int main()
{
    int t; cin >> t;
    while (t--)
	{
		long long int n; cin >> n;
		Solution ob;
		cout << ob.colName (n) << '\n';
	}
}

// } Driver Code Ends