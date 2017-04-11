import java.util.Arrays;

/**
 * Created by 马佳 on 2017/4/9.
 */
public class Accumulation {
    int n;
    int[] arr;
    public Accumulation(int n) {
        this.n = n;
        arr = new int[n = 1];
    }

    public static int calculate(int n) {
        if (n == 1) {
            return n;
        } else {
            return calculate(n - 1) + n;
        }
    }

    public int calculateReturnByException(int i) {
        try{
            arr[i] = arr[i - 1] + i;
            return calculateReturnByException(i + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            return arr[n];
        }

    }
}
