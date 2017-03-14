package ru.tn.courses.ntseytlina.task1.v2.subtask4;

import java.util.*;

/**
 * На вход подается строка,
 * необходимо определить подстроку с наибольшей длиной,
 * которая встречается в исходной строке наибольшее количество раз.
 * Результат: вывод этой подстроки и количество вхождений
  */

public class Main {

    private static String string = "utmr" +
            "utmr" +
            "abyc" +
            "utmr" +
            "abyc" +
            "abyc";

    public static void main(String [] args) {
        System.out.println(findMostFrequentString());
    }

    private static List<List> findMostFrequentString () {
        List<String> substringKeys = new ArrayList<>();
        List<Integer> substringFrequency = new ArrayList<>();

        List<List> mostFrequentStrings = new ArrayList<List>() {{
            add(new ArrayList<String >());
            add(new ArrayList<Integer>());
        }};

        for (int i = 2; i < string.length(); i++) {
            for (int j = i; j < string.length() + 1; j++) {
                String key = string.substring(j - i, j);
                if (substringKeys.contains(key)) {
                    int index = substringKeys.indexOf(key);
                    substringKeys.set(index, key);
                    substringFrequency.set(index, substringFrequency.get(index) + 1);
                } else {
                    substringKeys.add(key);
                    substringFrequency.add(1);
                }
            }
        }

        int numberOfSubstrings = 0;
        int length = 0;

        for (String key : substringKeys) {
            int index = substringKeys.indexOf(key);
            if (substringFrequency.get(substringKeys.indexOf(key)) > numberOfSubstrings) {
                numberOfSubstrings = substringFrequency.get(index);
                mostFrequentStrings.get(0).clear();
                mostFrequentStrings.get(1).clear();
                mostFrequentStrings.get(0).add(key);
                mostFrequentStrings.get(1).add(substringFrequency.get(index));
                length = key.length();
            } else if (substringFrequency.get(substringKeys.indexOf(key)) == numberOfSubstrings) {
                mostFrequentStrings.get(0).add(key);
                mostFrequentStrings.get(1).add(substringFrequency.get(index));
                if (length < key.length()) {
                    length = key.length();
                }
            }
        }

        List<String> keys = new ArrayList<>(mostFrequentStrings.get(0));

        for (String key : keys) {
            if (key.length() < length) {
                mostFrequentStrings.get(1).remove(mostFrequentStrings.get(0).indexOf(key));
                mostFrequentStrings.get(0).remove(key);
            }
        }

        return mostFrequentStrings;
    }

}
