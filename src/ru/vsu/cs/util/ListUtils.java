package ru.vsu.cs.util;

import ru.vsu.cs.novichikhin.SimpleLinkedList;

public class ListUtils {

    public static SimpleLinkedList<Double> convertToLinkedList(double[] array) {
        SimpleLinkedList<Double> linkedList = new SimpleLinkedList<>();

        for (double number : array) {
            linkedList.addLast(number);
        }
        return linkedList;
    }

    public static String[] convertToStringArray(SimpleLinkedList<Double> list) {
        String[] array = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = String.valueOf(list.get(i));
        }

        return array;
    }
}
