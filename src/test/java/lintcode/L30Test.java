package lintcode;

import lintcode.util.Interval;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoubo
 * @create 2017-11-02 11:15
 */
public class L30Test {
    @Test
    public void insert() throws Exception {
        List<Interval> intervals = new LinkedList<>();
//        intervals.add(new Interval(3, 4));
        intervals.add(new Interval(1, 5));
//        intervals.add(new Interval(5, 9));
        Interval newInterval = new Interval(2, 3);
        List<Interval> result = new L30().insert(intervals, newInterval);
        System.out.println(result);
    }

}