class SeatManager {

    int[] arr;
    int low, size;
    public SeatManager(int n) {
        arr = new int[n+1];

        for(int i = 0; i<=n; i++) {
            arr[i] = i;
        }
        low = 1;
        size = n;
    }

    private void swap(int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    private void heapify(int ind) {
        int left = 2*ind;
        int right = 2*ind + 1;
        int index = -1;
        if(right<=size) {
            index = arr[left]<=arr[right]?left:right;
        } else if(left<=size) {
            index = left;
        }
        if(index!=-1 && arr[index]<arr[ind]) {
            swap(ind, index);
            heapify(index);
        }
    }

    public int reserve() {
        int ans = arr[low];
        swap(low, size);
        size --;
        heapify(low);
        return ans;
    }
    
    public void unreserve(int seatNumber) {
        arr[++size] = seatNumber;
        int index = size;
        while(arr[index]<arr[index/2]) {
            swap(index, index/2);
            index = index/2;
        }
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */