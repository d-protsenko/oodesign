package ru.omsu.imit.factory;

import static org.junit.Assert.*;

import ru.omsu.imit.factory.sortings.ISort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import ru.omsu.imit.factory.sortings.Sorting;

public class SortingFactoryTest {
    private SortingFactory sortingFactory = new SortingFactory();

    private int[] randomArray(final int min, final int limit) {
        Random random = new Random(System.currentTimeMillis());
        int[] array = new int[random.nextInt(limit)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(limit) + min;
        }
        return array;
    }

    @Test
    public void sortingFactoryTest() {
        final int min = -100, limit = 1000;

        int[] array1 = randomArray(min, limit);
        int[] sortedArray1 = sortingFactory.getSort(Sorting.SHELL).sort(array1);
        Arrays.sort(array1);
        assertArrayEquals(array1, sortedArray1);

        int[] array2 = randomArray(min, limit);
        int[] sortedArray2 = sortingFactory.getSort(Sorting.HEAP).sort(array2);
        Arrays.sort(array2);
        assertArrayEquals(array2, sortedArray2);

        int[] array3 = randomArray(min, limit);
        int[] sortedArray3 = sortingFactory.getSort(Sorting.RADIX).sort(array3);
        Arrays.sort(array3);
        assertArrayEquals(array3, sortedArray3);
    }

    @Test
    public void sortingFactoryNewObjects() {
        ISort sort1 = sortingFactory.getSort(Sorting.RADIX);
        ISort sort2 = sortingFactory.getSort(Sorting.RADIX);
        assertNotEquals(sort1, sort2);
    }
}