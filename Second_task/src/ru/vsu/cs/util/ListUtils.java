package ru.vsu.cs.util;

import ru.vsu.cs.novichikhin.SimpleLinkedList;

import java.io.FileNotFoundException;
import java.util.*;

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

    public static String toString(SimpleLinkedList<Double> list) {
        if (list == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i != list.size() - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }


    public static List<SimpleLinkedList<Double>> toList(String[] lines) {
        List<SimpleLinkedList<Double>> list = new ArrayList<>();
        for (String line : lines) {
            list.add(toLinkedList(line));
        }
        return list;
    }

    public static List<SimpleLinkedList<Double>> readListFromFile(String fileName) {
        try {
            return toList(ArrayUtils.readLinesFromFile(fileName));
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static SimpleLinkedList<Double> readLinkedListFromFile(String fileName) {
        try {
            return toLinkedList(ArrayUtils.readLinesFromFile(fileName)[0]);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static SimpleLinkedList<Double> toLinkedList(String string) {
        Scanner scanner = new Scanner(string);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        SimpleLinkedList<Double> list = new SimpleLinkedList<>();

        while (scanner.hasNext()) {
            list.addLast(scanner.nextDouble());
        }

        return list;
    }
}
