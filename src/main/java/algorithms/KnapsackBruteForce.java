package algorithms;

public class KnapsackBruteForce {

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int capacity = 50;

        int maxValue = knapsack(items, capacity);
        System.out.println("Maximum value: " + maxValue);
    }

    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    /**
     * Returns the maximum value that can be put in a knapsack with the given capacity.
     * Each item can only be selected once. If you pack an item it consumes its weight in the capacity
     * Your algorithm should implement a brute-force appraoch with a time comlexity
     * of O(2^n) where n is the number of items.
     * @param items
     * @param capacity
     * @return
     */
    public static int knapsack(Item[] items, int capacity) {
         int maxValue = 0;
         int currentValue = 0;

         if(items.length == 0) {return 0;}

         for (int i = 0; i < items.length; i++) {
             if (items[i].weight < capacity) {
                 if (items[i].value > maxValue) {
                     maxValue = items[i].value;
                 }
             }
         }
         for (int i = 0; i < items.length-1; i++) {
             if (items[i].weight + items[i+1].weight <=  capacity) {
                 currentValue = items[i].value + items[i+1].value;
                 System.out.println(currentValue);
                 if (currentValue > maxValue) {
                     maxValue = currentValue;
                 }
             }
         }
        return maxValue;
    }


}
