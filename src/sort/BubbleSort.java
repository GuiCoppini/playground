package sort;

public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        int[] sorted = array.clone();

        while (!isSorted(sorted)) {
            for (int i = 0; i < sorted.length -1; i++) {
                if (sorted[i] > sorted[i + 1]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                }
            }
        }

        return sorted;
    }

    private boolean isSorted(int[] array) {
        int before = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < before)
                return false;
            before = array[i];
        }
        return true;
    }
}
