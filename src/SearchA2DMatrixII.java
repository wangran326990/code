public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        int mid = (start + end) / 2;
        boolean result = false;
        if(matrix[mid][0] == target) {
            return true;
        }else if(matrix[mid][0] > target) {
            for(int i = mid + 1; i <= end; i++) {
                result = findTarget(matrix[i], target);
                if(result == true) break;
            }
        }else {
            for(int i =0; i <= mid; i++) {
                result = findTarget(matrix[i], target);
                if(result == true) break;
            }
        }
        return result;
    }

    private boolean findTarget(int[] arr, int target) {

        if(target < arr[0] || target > arr[arr.length -1]) return false;
        int start = 0;
        int end = arr.length -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) {
                return true;
            }else if(arr[mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }
}
