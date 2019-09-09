package ru.omsu.imit.factory;

import ru.omsu.imit.factory.sortings.HeapSort;
import ru.omsu.imit.factory.sortings.ISort;
import ru.omsu.imit.factory.sortings.RadixSort;
import ru.omsu.imit.factory.sortings.ShellSort;
import ru.omsu.imit.factory.sortings.Sorting;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Supplier;

public class SortingFactory {
    private static final Supplier<ISort> makeShellSort = ShellSort::new;
    private static final Supplier<ISort> makeRadixSort = RadixSort::new;
    private static final Supplier<ISort> makeHeapSort = HeapSort::new;

    private Map<Sorting, Supplier> sortMap;

    public SortingFactory() {
        sortMap = new HashMap<>();
        sortMap.put(Sorting.SHELL, makeShellSort);
        sortMap.put(Sorting.RADIX, makeRadixSort);
        sortMap.put(Sorting.HEAP, makeHeapSort);
    }

    public ISort getSort(Sorting sort) {
        if (!sortMap.containsKey(sort)) {
            return null;
        }
        return (ISort)sortMap.get(sort).get();
    }
}
