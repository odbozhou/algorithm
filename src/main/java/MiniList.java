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
            Comparable<T> comp = (Comparable<T>)a;
            return comp.compareTo(b);
        }
    }

    public T getMax() {
        ListNode<T> p = head;
        if (null == p.next) {
            return null;
        }
        T max = p.next.value;
        while (null != p.next) {
            if (this.compare(p.next.value, max) > 0) {
                max = p.next.value;
                p = p.next;
            }
        }
        return max;
    }

    public int add(T value) {
        ListNode<T> p = head;
        while(null != p.next) {
            p = p.next;
        }
        ListNode<T> q = new ListNode<T>(value, null);
        p.next = q;
        return 1;
    }

    public int remove(int index) {
        ListNode<T> p = head;
        if (null == p.next) {
            return 0;
        }
        for (int i = 0; null != p.next; i++) {
            if (i == index) {
                ListNode<T> q = p.next.next;
                p.next = q;
            }
            if (null != p.next) {
                p = p.next;
            }
        }
        return 1;
    }
}
