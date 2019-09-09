package ru.omsu.imit.factory.sortings;

public class RadixSort implements ISort {

    public int[] sort(final int[] array) {
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);

        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
            int[] tmp = new int[sortedArray.length];
            int j = 0;

            for (int i = 0; i < sortedArray.length; i++) {
                boolean move = sortedArray[i] << shift >= 0;

                if ((shift == 0) != move) {
                    tmp[j] = sortedArray[i];
                    j++;
                } else {
                    sortedArray[i - j] = sortedArray[i];
                }
            }

            if (tmp.length - j >= 0) System.arraycopy(sortedArray, 0, tmp, j, tmp.length - j);
            sortedArray = tmp;
        }
        return sortedArray;
    }
}