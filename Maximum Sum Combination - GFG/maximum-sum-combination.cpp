//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
   public:
    //Function to find maximum sum combinations from two arrays.
    vector<int> maxCombinations(int N, int K, vector<int> &A, vector<int> &B) {
        //sorting both arrays in ascending order.
        sort(A.begin(), A.end());
        sort(B.begin(), B.end());
        vector<int> ans;

        //creating a priority queue to store maximum sums of combinations.
        priority_queue<pair<int, pair<int, int>>> pq;

        //creating a set to store visited combinations.
        set<pair<int, int>> my_set;

        //pushing the maximum sum of combinations obtained from last elements
        //of both arrays along with their indices.
        pq.push(make_pair(A[N - 1] + B[N - 1], make_pair(N - 1, N - 1)));

        //inserting the indices of last elements in set.
        my_set.insert(make_pair(N - 1, N - 1));

        //iterating K times to find K maximum sum combinations.
        for (int count = 0; count < K; count++) {
            //popping the maximum sum from priority queue.
            pair<int, pair<int, int>> temp = pq.top();
            pq.pop();

            //storing the maximum sum in the answer array.
            ans.push_back(temp.first);

            //getting the indices of the elements used to get the maximum sum.
            int i = temp.second.first;
            int j = temp.second.second;

            //checking if it is possible to consider the next element
            //from A array and calculating the sum.
            if (i - 1 >= 0) {
                int sum = A[i - 1] + B[j];

                //creating a pair to store the indices.
                pair<int, int> temp1 = make_pair(i - 1, j);

                //checking if the pair already exists in the set.
                if (my_set.find(temp1) == my_set.end()) {
                    //if not, pushing the sum and indices to priority queue
                    //and inserting the indices in set.
                    pq.push(make_pair(sum, temp1));
                    my_set.insert(temp1);
                }
            }

            //checking if it is possible to consider the next element
            //from B array and calculating the sum.
            if (j - 1 >= 0) {
                int sum = A[i] + B[j - 1];

                //creating a pair to store the indices.
                pair<int, int> temp1 = make_pair(i, j - 1);

                //checking if the pair already exists in the set.
                if (my_set.find(temp1) == my_set.end()) {
                    //if not, pushing the sum and indices to priority queue
                    //and inserting the indices in set.
                    pq.push(make_pair(sum, temp1));
                    my_set.insert(temp1);
                }
            }
        }
        
        //returning the answer array containing the maximum sum combinations.
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        cin >> N >> K;

        vector<int> A(N), B(N);
        for (int i = 0; i < N; i++) {
            cin >> A[i];
        }
        for (int i = 0; i < N; i++) {
            cin >> B[i];
        }
        Solution obj;
        vector<int> ans = obj.maxCombinations(N, K, A, B);
        for (auto &it : ans) cout << it << ' ';
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends