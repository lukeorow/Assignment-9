import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {
    
    private T[] array;
    
    public void sort(T[] array) {
        this.array = array;
        mergeSort(0, array.length - 1);
    }
    
    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }
    
    private void merge(int low, int mid, int high) {
        T[] temp = (T[]) new Comparable[high - low + 1];
        int leftIndex = low;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        
        while (leftIndex <= mid && rightIndex <= high) {
            if (array[leftIndex].compareTo(array[rightIndex]) <= 0) {
                temp[tempIndex] = array[leftIndex];
                leftIndex++;
            } else {
                temp[tempIndex] = array[rightIndex];
                rightIndex++;
            }
            tempIndex++;
        }
        
        while (leftIndex <= mid) {
            temp[tempIndex] = array[leftIndex];
            leftIndex++;
            tempIndex++;
        }
        
        while (rightIndex <= high) {
            temp[tempIndex] = array[rightIndex];
            rightIndex++;
            tempIndex++;
        }
        
        for (int i = 0; i < temp.length; i++) {
            array[low + i] = temp[i];
        }
    }
    
    public static void main(String[] args) {
        Integer[] array = {139, 12, 313, 121, 9000, 31, 223, 123, 12, 1, 0};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
