package lintcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class L657 {
}


class RandomizedSet {
    Set set = new HashSet<Integer>();

    public RandomizedSet() {
        // do intialization if necessary
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        return set.add(val);
    }


    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        Iterator<Integer> iterator = set.iterator();
        Random random = new Random();
        random.nextInt();
        int pos = (int) (Math.random() * (set.size() - 1));
        int i = 0;
        while (iterator.hasNext()) {
            int value = iterator.next().intValue();
            if (i == pos) {
                return value;
            }
            i++;
        }
        return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */