/**
 * 猴子每天吃前一天剩下的一半加一个桃子，第十天剩余1个桃子
 * 问：猴子一共有多少桃子？
 *
 * 分析：A(n-1) = A(n-1)/2 + 1 + An   An表示当天剩余的桃子
 *  An-1=  2 + 2An => An = 2 + 2An-1
 *  A1 = 1, A2 = 4
 *
 * Created by 马佳 on 2017/4/9.
 */
public class MonkeyEatPeaches {

    public static int caculatePeachRecursive(int day) {
        if (day == 1) {
            return 1;
        } else {
            return caculatePeachRecursive (day - 1) * 2 + 2;
        }
    }

    public static int caculatePeach(int n) {
        int a = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            System.out.println("day " + (n - i + 1) + " remaing: " + a);
            a = a * 2 + 2;
            sum += sum + a;
        }
        return sum;
    }

    /**
     * An = An-1 / 2  - 1
     * @param num
     * @return
     */
    public static int simulateEat(int num) {
        if (num == 1) {
            return 1;
        } else {
            num = num / 2 -1;
            System.out.println("remaing: " + num + " peach");
            return simulateEat(num);
        }
    }
/*    public static void main(String[] args) {
        int n = 10;
        System.out.println("peach total number: " + caculatePeach1(n));
        System.out.println("peach total number: " + caculatePeach(n));

    }*/
}
