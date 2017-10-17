package lintcode;

import lintcode.util.Interval;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiajia on 2017/10/17.
 */
public class L156 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Point> points = new LinkedList<Point>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, 1));
            points.add(new Point(interval.end, 0));
        }
        Collections.sort(points);
        for (Point point : points) {
            boolean startEndFlag = true;
            Interval interval = null;
            if (1 == point.flag) {
                if (startEndFlag) {
                    interval = new Interval(point.value, 0);
                } else {
                    continue;
                }
            }
            if (0 == point.flag) {

            }

            while (0 == point.flag) {

            }

        }
    }
}

class Point implements Comparable<Point>{
    int value;
    int flag;

    public Point(int value, int flag) {
        this.value = value;
        this.flag = flag;
    }

    public int compareTo(Point o) {
        if (this.value == o.value) {
            return this.flag - o.flag;
        } else {
            return this.value - o.value;
        }
    }
}