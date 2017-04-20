import java.util.Comparator;
import java.util.Stack;

/**
 * Created by jiajia on 2017/4/20.
 */
public class MiniList<T> {
    public ListNode<T> head = new ListNode<T>(null ,null);
    public void arrayAsList(T[] array) {
        ListNode<T> p = head;
        for(T a : array) {
            p.next = new ListNode<T>(a, null);
            p = p.next;
        }
    }

    public void print() {
        ListNode<T> p = head;
        while (null != p.next) {
            System.out.println(p.next.value);
            p = p.next;
        }
    }

    public void printReverse() {
        Stack<T> stack = new Stack<T>();
        ListNode<T> p = head;
        while (null != p.next) {
            stack.push(p.next.value);
            p = p.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
    }
    }

    public void recursive(ListNode<T> p) {
        if (null != p) {
            recursive(p.next);
            System.out.println(p.value);
        }
    }

    public void printRecursive() {
        ListNode<T> p = head;
        recursive(p.next);
    }

    public Comparator<T> comparator;

    public int compare(T a, T b) {
        if (null != comparator) {
            return comparator.compare(a, b);
        } else {
            Comparator<T> comp = (Comparator<T>)a;
            return comp.compare(a, b);
        }
    }

    public T getMax() {
        ListNode<T> p = head;
        if (null == p.next) {
            return null;
        }
        T max = p.next.value;
        while (null != p.next) {
            if ()
        }
    }
}
