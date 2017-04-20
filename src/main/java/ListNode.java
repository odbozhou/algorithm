/**
 * Created by jiajia on 2017/4/20.
 */
public class ListNode<T> {
    public T value;
    public ListNode<T> next;
    public ListNode (T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }
//    public ListNode<T> pre = new ListNode<T>(null ,null);
}
