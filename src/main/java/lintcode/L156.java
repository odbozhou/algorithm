package lintcode;

import lintcode.util.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiajia on 2017/10/17.
 */
public class L156 {

/*    public static Comparator<Interval> comparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };*/

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(i -> i.start));
        Interval last = null;
        List<Interval> resultInterval = new LinkedList<>();
        for (Interval interval : intervals) {
            if (null == last || last.end <= interval.start) {
                last = interval;
                resultInterval.add(last);
            } else {
                last.end = Math.max(last.end, interval.end);
            }
        }
        return resultInterval;
    }


    public List<Interval> merge1(List<Interval> intervals) {
        List<Pixel> pixels = new LinkedList<Pixel>();
        for (Interval interval : intervals) {
            pixels.add(new Pixel(interval.start, 1));
            pixels.add(new Pixel(interval.end, 0));
        }
        Collections.sort(pixels);
        for (int i = 0; i < pixels.size(); i++) {
            if (1 == pixels.get(i).flag) {
                if (i + 1 < pixels.size()) {
                    if (pixels.get(i).flag == pixels.get(i + 1).flag) {
                        pixels.remove(i + 1);
                    }
                }
            } else {
                if (i + 1 < pixels.size()) {
                    if (pixels.get(i).flag == pixels.get(i + 1).flag) {
                        pixels.remove(i);
                    }
                }
            }
        }
        List<Interval> intervalList = new LinkedList<Interval>();
        if (pixels.size() > 2) {
            for (int i = 1; i < pixels.size() - 1; i++) {
                if (pixels.get(i).value == pixels.get(i + 1).value || pixels.get(i).value + 1 == pixels.get(i + 1).value) {
                    pixels.remove(i + 1);
                    pixels.remove(i);
                }
            }
        }
        for (int i = 0; i < pixels.size(); i = i + 2) {
            intervalList.add(new Interval(pixels.get(i).value, pixels.get(i + 1).value));
            System.out.println(" pixels.get(i) " + pixels.get(i).value + " pixels.get(i + 1) " + pixels.get(i + 1).value);
        }
        return intervalList;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<Interval>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(1, 10));
        new L156().merge(intervals);
    }
}

class Pixel implements Comparable<Pixel> {
    int value;
    int flag;

    public Pixel(int value, int flag) {
        this.value = value;
        this.flag = flag;
    }

    @Override
    public int compareTo(Pixel o) {
        if (this.value == o.value) {
            return this.flag - o.flag;
        } else {
            return this.value - o.value;
        }
    }
}