package lintcode;

import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


/*public class NestedIterator implements Iterator<Integer> {

    private List<NestedInteger> nestedIntegers;
    private Iterator<NestedInteger>  iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedIntegers = nestedList;
        iterator = nestedList.iterator();
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
    }

    @Override
    public void remove() {
    }
}*/
/*class Node {
    List<Integer> integers = null;
    Integer integer = null;
    public Node(List<Integer> integers, Integer integer) {
        this.integers = integers;
        this.integer = integer;
    }
}
class MyNestedInteger implements NestedInteger{

    public MyNestedInteger(List<Integer> integers) {
        this.integers = integers;
    }
    @Override
    public boolean isInteger() {
        if (null != integers && 1 ==integers.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}*/

/**
 * 摊平嵌套的列表
 *
 * @author zhoubo
 * @create 2017-11-14 17:04
 */
public class L528 {
}
