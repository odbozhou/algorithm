package lintcode;

import lintcode.util.Interval;

import java.util.*;

public class L391 {
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Point> points = new LinkedList<Point>();
        for (Interval interval : airplanes) {
            points.add(new Point(interval.start, 1));
            points.add(new Point(interval.end, 0));
        }
        Collections.sort(points, Point.comparator);
        int max = 0;
        int count = 0;
        for (Point point : points) {
            System.out.println("point time = " + point.time);
            System.out.println("point flag = " + point.flag);

            if (1 == point.flag) {
                count++;
            } else {
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>(16);
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(5, 8));
        intervals.add(new Interval(4, 7));
        System.out.println(new L391().countOfAirplanes(intervals));
    }
}

class Point {
    int time;
    int flag;

    public Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
    public static Comparator<Point> comparator = new Comparator<Point>() {
        public int compare(Point o1, Point o2) {
            if (o1.time == o2.time) {
                return o1.flag - o2.flag;
            } else {
                return o1.time - o2.time;
            }
        }
    };
}

