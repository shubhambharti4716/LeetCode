class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // Start searching from the middle index
        int i = arr.length / 2; 
        
        // Initialize the length of the subarray to search
        int arrLen = i; 

        while (true) {
            // Check if the current element is greater than its adjacent elements
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1])
                break; // If it is a peak, exit the loop and return the peak index

            // If the element at index 'i' is less than the next element, search in the ascending part
            if (arr[i] < arr[i + 1]) {
                arrLen /= 2; // Reduce the search range by half
                i += arrLen; // Move 'i' to the right to explore the next subarray
            } else {
                // If the element at index 'i' is greater than or equal to the next element, search in the descending part
                i -= arrLen / 2; // Reduce the search range by half and shift 'i' left to explore the descending part
            }
        }

        return i; // Return the index of the peak element
    }
}
