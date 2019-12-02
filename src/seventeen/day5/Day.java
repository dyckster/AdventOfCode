package seventeen.day5;

import utils.Util;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day {
    public static void main(String[] args) {
        String input = Util.readFromFile(Paths.get("resources/2017/input5.txt"));
        String[] lines = input.split("\\n");
        List<Integer> vals = new ArrayList<>();
        for (String line : lines) {
            vals.add(Integer.parseInt(line));
        }
//        taskOne(vals);
        taskTwo(vals);

    }

    private static void taskOne(List<Integer> vals) {
        int jumpCount = 0;

        for (int i = 0; i < vals.size(); i++) {
            jumpCount++;
            int value = vals.get(i);
            System.out.println("On: " + value);
            int newValue = value + 1;
            System.out.println("New value : " + newValue);
            vals.set(i, newValue);
            i = i + value - 1;
            try {
                System.out.println("Jumping to position: " + i + " with value: " + vals.get(i));
            } catch (Exception e) {
                continue;
            } finally {
                System.out.println("--------------------------");
            }
        }
        System.out.println("Jump count: " + jumpCount);
        System.out.println("List size: " + vals.size());
    }

    private static void taskTwo(List<Integer> vals) {
        int jumpCount = 0;

        for (int i = 0; i < vals.size(); i++) {
            jumpCount++;
            int value = vals.get(i);
//            System.out.println("On: " + value);

            int newValue = value + 1;
            if (value >= 3) {
                newValue = value - 1;
            }
//            System.out.println("New value:  " + newValue);
            vals.set(i, newValue);
            i = i + value - 1;
            try {
//                System.out.println("Jumping to position: " + i + " with value: " + vals.get(i));
            } catch (Exception e) {
                continue;
            } finally {
//                System.out.println("--------------------------");
            }
        }
        System.out.println("Jump count: " + jumpCount);
        System.out.println("List size: " + vals.size());
    }
}
