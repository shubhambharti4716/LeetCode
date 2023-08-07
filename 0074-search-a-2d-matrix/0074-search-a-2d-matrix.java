class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            int low = 0, high = matrix[i].length-1;
            while(low<=high){
                int mid = low+ (high-low)/2;
                if(matrix[i][mid] == target){
                    return true;
                }else if(matrix[i][mid]>target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return false;
    }
}