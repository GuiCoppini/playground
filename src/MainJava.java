import sort.BubbleSort;
import sort.Sort;

import java.util.Arrays;
import java.util.function.Function;

public class MainJava {
    public static void main(String[] args) {
        Sort sort = new BubbleSort();

        checkSort(sort::sort);
        System.out.printf("Success!");
    }

    static boolean checkSort(Function<int[], int[]> sortFunc) {
        int[][] arrays = {{4, 6, 2, 1, 9, 0},
                {1, 3, 5, 7, 99},
                {5, 4},
                {4, 5},
                {0},
                {1, 2, 3, 4, 2}};

        for (int[] array : arrays) {
            int[] finalArray = sortFunc.apply(array);
            if(!isSorted(finalArray)) {
                throw new RuntimeException("Failed with array: " + Arrays.toString(array));
            }
            if(!sameNumbers(array, finalArray)) {
                throw new RuntimeException("Arrays are different: " +  Arrays.toString(array) + " and " +  Arrays.toString(finalArray));
            }
        }

        return false;
    }

    static boolean isSorted(int[] array) {
        int before = array[0];
        for(int i = 1; i< array.length; i++) {
            if(array[i] < before)
                return false;
            before = array[i];
        }
        return true;
    }

    static boolean sameNumbers(int[] array1, int[] array2) {
        int[] clone1 = array1.clone();
        int[] clone2 = array2.clone();

        Arrays.sort(clone1);
        Arrays.sort(clone2);

        return Arrays.equals(clone1, clone2);
    }
}
