package leetcode;

/**
 * Created by zhoubo on 2017/6/22.
 */
public class L240SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (0 != matrix.length && 0 == matrix[0].length) {
            return false;
        }
        int row = binarySearch(matrix[0], target);
        int n = matrix.length;
        int low = 0;
        int high = n - 1;
        int mid = (low + high) / 2;
        if (matrix[mid][row] == target) {
            return true;
        }
        while (low < high) {
            if (target == matrix[mid][row]) {
                return true;
            } else if (target > matrix[mid][row]) {
                low = mid + 1;
            } else {
                high = mid;
            }
            mid = (low + high) / 2;
        }
        if (low == high && target == matrix[mid][row]) {
            return true;
        } else {
            return false;
        }
    }

    private int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        while (low < high) {
           if (key == arr[mid]) {
               return mid;
           } else if (key > arr[mid]){
               low = mid + 1;
           } else {
               high = mid;
           }
           mid = (low + high) / 2;
        }
        if (low == high && key == arr[mid]) {
            return mid;
        }
        if (low > 0 && key < arr[low]) {
            return low - 1;
        }
        return low == 0 || low == arr.length - 1 ? low : low - 1;
    }
}
