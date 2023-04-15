import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> {
    
    private T[] array;
    
    public void sort(T[] array) {
        this.array = array;
        bubbleSort();
    }
    
    private void bubbleSort() {
        int n = array.length;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    swap(i - 1, i);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    
    private void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        Integer[] array = {7, 12, 311, 12312, 43, 123, 3, 123, 2, 31, 538, 1090, 123, 84};
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
