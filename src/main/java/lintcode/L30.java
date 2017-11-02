package lintcode;

import lintcode.util.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 插入区间
 *
 * @author zhoubo
 */
public class L30 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (null == newInterval) {
            return intervals;
        }
        intervals.add(newInterval);
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        List<Interval> result = new LinkedList<>();
        Interval last = null;
        for (Interval interval : intervals) {
            if (null == last) {
                last = interval;
            }
            if (result.isEmpty()) {
                result.add(last);
            } else {
                if (last.end < interval.start) {
                    result.add(interval);
                    last = interval;
                } else if (interval.end > last.end) {
                    last.end = interval.end;
                }
            }
        }
        return result;
    }
}


