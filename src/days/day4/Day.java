package days.day4;

import utils.Util;

import java.nio.file.Paths;
import java.util.*;

public class Day {

    public static void main(String[] args) {
        String input = Util.readFromFile(Paths.get("input4.txt"));
        taskOne(input);
        taskTwo(input);

    }

    private static void taskOne(String input) {
        String[] lines = input.split("\\n");
        int validLines = 0;

        for (String line : lines) {
            String[] words = line.split("\\W+");
            HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
            if (uniqueWords.size() == words.length) {
                validLines++;
            }

            System.out.println(line);
        }
        System.out.println("All lines: " + lines.length);
        System.out.println("Valid lines: " + validLines);
    }

    private static void taskTwo(String input) {
        String[] lines = input.split("\\n");
        int validLines = 0;

        for (String line : lines) {
            String[] words = line.split("\\W+");
            HashSet<String> uniqueWords = new HashSet<>();
            for (String word : words) {
                System.out.println("Original word: " + word);
                char[] originalWord = word.toCharArray();
                Arrays.sort(originalWord);
                String newWord = new String(originalWord);
                System.out.println("Sorted word: " + newWord);
                uniqueWords.add(newWord);
            }

            if (uniqueWords.size() == words.length) {
                validLines++;
            }

            System.out.println(line);
        }
        System.out.println("All lines: " + lines.length);
        System.out.println("Valid lines: " + validLines);
    }
}
