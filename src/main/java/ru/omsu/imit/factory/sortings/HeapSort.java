package ru.omsu.imit.factory.sortings;

public class HeapSort implements ISort {

    private void heapify(final int[] array, final Integer n, final Integer i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    public int[] sort(final int[] array) {
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);

        int n = sortedArray.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(sortedArray, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = sortedArray[0];
            sortedArray[0] = sortedArray[i];
            sortedArray[i] = temp;

            heapify(sortedArray, i, 0);
        }
        return sortedArray;
    }
}
