package ru.omsu.imit.factory.sortings;

public class ShellSort implements ISort {

    public int[] sort(final int[] array) {
        int[] sortedArray = new int[array.length];
        System.arraycopy(array, 0, sortedArray, 0, array.length);

        int increment = sortedArray.length / 2;
        while (increment > 0) {
            for (int i = increment; i < sortedArray.length; i++) {
                int j = i;
                int temp = sortedArray[i];
                while (j >= increment && sortedArray[j - increment] > temp) {
                    sortedArray[j] = sortedArray[j - increment];
                    j = j - increment;
                }
                sortedArray[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
        return sortedArray;
    }
}