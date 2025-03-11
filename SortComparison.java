import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // Merge Sort for Integer Arrays
    public static void mergeSort(int[] array) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge both arrays until one is exhausted
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    // Bubble Sort for Integer Arrays
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }

    // Method to generate a random integer array
    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    
    public static void main(String[] args) {
        int size = 1000; // Adjust size for testing
        int bound = 10000;

        int[] array1 = generateRandomArray(size, bound);
        int[] array2 = Arrays.copyOf(array1, array1.length);

        // Measure time for Merge Sort
        long startMerge = System.nanoTime();
        mergeSort(array1);
        long endMerge = System.nanoTime();
        System.out.println("Merge Sort took: " + (endMerge - startMerge) + " ns");

        // Measure time for Bubble Sort
        long startBubble = System.nanoTime();
        bubbleSort(array2);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort took: " + (endBubble - startBubble) + " ns");
    }
}
