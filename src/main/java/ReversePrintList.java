import java.util.Stack;

/**
 * Created by jiajia on 2017/4/20.
 */
public class ReversePrintList {
    public void print(ListNode<?> listNode) {
        Stack stack = new Stack();
        while(null != listNode) {
            stack.push(listNode.value);
            listNode = listNode.next;
        }
        while(!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

