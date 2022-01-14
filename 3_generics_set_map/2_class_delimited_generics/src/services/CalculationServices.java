package services;

import java.util.List;

public class CalculationServices<T> {

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException();
        }
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T sum(List<T> list) {
        if(list.isEmpty()){
            throw new IllegalStateException();
        }
    }

}
