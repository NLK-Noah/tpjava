package algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.Map;



/**
 * This interface represents a collection of integers, similar to a set but allowing duplicates.
 * The collection is iterable and provides basic operations like adding, removing,
 * and counting elements.
 *
 * Here is an example of how to use a Bag:
 *
 *         Bag b = create();
 *         b.add(4);
 *         b.add(8);
 *         b.add(4);
 *         b.add(2);
 *         // at this point the content of the bag is {4, 8, 4, 2} (the order is not important)
 *         b.count(4); // returns 2 since there are two occurrences of 4 in the bag
 *         b.count(1); // returns 0 since there are no occurrences of 1 in the bag
 *         b.count(8); // returns 1 since there is one occurrence of 8 in the bag
 *         b.remove(4);
 *         // at this point the content of the bag is {4, 8, 2}
 *         b.count(4); // returns 1 since there is one occurrence of 4 in the bag
 *         b = b.filter(x -> x >= 4); // returns a new Bag containing 4, 8 since only those elements are >= 4
 *         // at this point the content of the bag is {4, 8}
 *         b.count(2); // returns 0 since there are no occurrences of 2 in the bag
 *         // iterate over the elements of the bag. This implicitly uses the iterator() method
 *         for (int i : b) { // prints 4, 8 (in any order)
 *             System.out.println(i);
 *         }
 *
 *   You have to complete the implementation of the Bag interface below.
 *
 */
public interface Bag extends Iterable<Integer> {
    Bag b = new BagImpl();
    /**
     * Adds the specified integer to the bag.
     * @param o The integer to add.
     */
    public void add(int o);

    /**
     * Removes one occurrence of the specified integer from the bag, if present.
     * @param o The integer to remove.
     */
    public void remove(int o);

    /**
     * Checks if the bag is empty.
     * @return true if the bag is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Counts the number of occurrences of a specified integer in the bag.
     * @param o The integer to count.
     * @return The number of occurrences of the integer.
     */
    public int count(int o);

    /**
     * Filters the bag based on a given predicate and returns a new bag containing
     * only elements that satisfy the predicate.
     * @param filter The predicate to apply to each element.
     * @return A new Bag containing the elements that satisfy the predicate.
     */
    public Bag filter(Predicate<Integer> filter);

    /**
     * Returns an iterator over elements of type {@code Integer}.
     * @return an Iterator.
     */
    public Iterator<Integer> iterator();

    /**
     * Creates a new instance of a Bag.
     * @return A new instance of a Bag.
     */
    public static Bag create() {
        return new BagImpl();
    }
}

class BagImpl implements Bag {
    // TODO: Implement the Bag interface here
    // Feel free to implement it using the data structure of your choice
    // or use any other class from the Java language to help you.
    // The time complexity of each method should be at most O(n) where n is the number of elements in the bag.

    private Map<Integer, Integer> bag;

    public BagImpl() {
        bag = new HashMap<>();
    }

    @Override
    public void add(int o) {
        bag.merge(o, 1, Integer::sum);

    }

    @Override
    public void remove(int o) {
        bag.computeIfPresent(o, (key, value) -> value > 1 ? value - 1 : null);
        ;

    }

    @Override
    public boolean isEmpty() {
        return bag.isEmpty();
    }

    @Override
    public int count(int o) {

        return bag.getOrDefault(o, 0);
    }

    @Override
    public Bag filter(Predicate<Integer> filter) {
        Bag b = new BagImpl();
        for (Map.Entry<Integer, Integer> entry : bag.entrySet()) {
            if (filter.test(entry.getKey())) {
                for (int i = 0; i < entry.getValue(); i++) {
                    b.add(entry.getKey());
                }
            }
        }
        return b;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private final Iterator<Map.Entry<Integer, Integer>> entryIterator = bag.entrySet().iterator();
            private Map.Entry<Integer, Integer> current = null;
            private int occurrencesLeft = 0;

            @Override
            public boolean hasNext() {
                // Vérifie s'il reste des occurrences ou des entrées
                return occurrencesLeft > 0 || entryIterator.hasNext();
            }

            @Override
            public Integer next() {
                // Si plus d'occurrences, avance au prochain élément
                if (occurrencesLeft == 0) {
                    current = entryIterator.next();
                    occurrencesLeft = current.getValue();
                }
                // Décrémente les occurrences restantes et retourne la clé actuelle
                occurrencesLeft--;
                return current.getKey();
            }
        };
    }
}
