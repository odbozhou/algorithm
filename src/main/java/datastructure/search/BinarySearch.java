package datastructure.search;

public class BinarySearch {
    public int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (arr[mid] == key) {
                return low;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return 0;
    }
}
