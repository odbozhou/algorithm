package asm;

/**
 * Created by jiajia on 2017/10/18.
 */
public abstract class ChildClass {
    public static int zero = 0;
    public abstract int compareT(Object var1);
    static {
        System.out.println("hello asm");
    }
}
