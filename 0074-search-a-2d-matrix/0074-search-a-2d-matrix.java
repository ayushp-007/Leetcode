class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = -1;
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(matrix[mid][0] <= target) {
                low = mid + 1;
                i = mid;
            }
            else high = mid - 1;
        }
        if(i == -1) return false;
        low = 0;
        high = m - 1;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(matrix[i][mid] == target) return true;
            if(matrix[i][mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}