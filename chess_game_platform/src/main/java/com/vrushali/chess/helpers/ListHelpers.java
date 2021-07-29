package com.vrushali.chess.helpers;

import java.util.ArrayList;
import java.util.List;

// Helper class related to @link list
public class ListHelpers {
    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> newList = new ArrayList<>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
