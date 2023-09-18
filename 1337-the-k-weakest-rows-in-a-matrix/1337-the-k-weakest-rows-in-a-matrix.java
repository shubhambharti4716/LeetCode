class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldiers = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            soldiers[i] = ceil(mat[i]);
        }

        int[] weakOrder = new int[k];
        for (int i = 0; i < k; i++) {
            int min = find(soldiers);
            soldiers[min] = -1;
            weakOrder[i] = min;
        }
        return weakOrder;

    }
    static int ceil(int[] row){
        int start = 0;
        int end = row.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if(row[mid] < 1){
                end = mid - 1;
            } else {
                start = mid +1;
            }
        }

        return start;
    }
    static int find(int[] arr) {
        int least = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] < least) {
                least = arr[i];
                index = i;
            }
        }
        return index;
    }
}