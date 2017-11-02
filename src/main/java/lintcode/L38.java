package lintcode;

/**
 * 搜索二维矩阵 II
 *
 * @author zhoubo
 * @create 2017-11-02 11:40
 */
public class L38 {
    public int searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if (0 == r) {
            return 0;
        }
        int count = 0;
        int cpos;
        cpos = binarySearch(matrix[0], target);
        int pos;
        if (cpos >= 0) {
            count++;
            for (int i = 0; i < cpos; i++) {
                pos = columnBinarySearch(matrix, i, target);
                if (pos > 0) {
                    count++;
                }
            }
        } else {
            for (int i = 0; i < -cpos - 1; i++) {
                pos = columnBinarySearch(matrix, i, target);
                if (pos > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int columnBinarySearch(int[][] a, int cpos, int key) {
        int start = 0;
        int end = a.length - 1;
        return columnBinarySearch(a, cpos, start, end, key);
    }

    public int columnBinarySearch(int[][] a, int cpos, int start, int end, int key) {
        int low = start;
        int high = end;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (a[mid][cpos] > key) {
                high = mid - 1;
            } else if (a[mid][cpos] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public int binarySearch(int[] a, int start, int end, int key) {
        int low = start;
        int high = end;
        int mid;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public int binarySearch(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        return binarySearch(a, start, end, key);
    }
}
