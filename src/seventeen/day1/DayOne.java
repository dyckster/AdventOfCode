package seventeen.day1;

import utils.Util;

import java.nio.file.Paths;

public class DayOne {
    public static void main(String[] args) {
        String input = Util.readFromFile(Paths.get("resources/2017/input1.txt"));

        calculateFirstTask(input.toCharArray());
        calculateSecondTask(input.toCharArray());
    }

    private static void calculateFirstTask(char[] input) {
        int currentSum = 0;
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            try {
                if (c == input[i + 1]) {
                    currentSum += Character.getNumericValue(c);
                }
            } catch (IndexOutOfBoundsException ex) {
                if (input[0] == input[input.length - 1]) {
                    currentSum += Character.getNumericValue(input[0]);
                }
            }

        }
        System.out.println("Result for first: " + currentSum);
    }

    private static void calculateSecondTask(char[] input) {

        int currentSum = 0;
        int step = input.length / 2;

        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            int position = i + step;
            if (position > input.length - 1) {
                position -= input.length;
            }
            if (c == input[position]) {
                currentSum += Character.getNumericValue(c);
            }

        }
        System.out.println("Result for second: " + currentSum);
    }


}
