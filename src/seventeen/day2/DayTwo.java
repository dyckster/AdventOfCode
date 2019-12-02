package seventeen.day2;

import utils.Util;

import java.nio.file.Paths;
import java.util.*;

public class DayTwo {

    private static final boolean USE_TEST = false;


    public static void main(String[] args) {
        String input = Util.readFromFile(Paths.get("resources/2017/input2" + (USE_TEST ? "test" : "") + ".txt"));
        calculateFirstTask(input);
        calculateSecondTask(input);
    }

    private static void calculateFirstTask(String input) {
        String[] splitLines = input.split("\\n");
        int checksum = 0;
        for (String splitLine : splitLines) {
            List<Integer> vals = new ArrayList<>();
            for (String s : splitLine.split("[^0-9]")) {
                int value = Integer.parseInt(s);
                vals.add(value);
            }
            int max = Collections.max(vals);
            int min = Collections.min(vals);
            int dif = max - min;
            checksum += dif;
        }
        System.out.println(checksum);
    }

    private static void calculateSecondTask(String input) {
        String[] splitLines = input.split("\\n");
        int checksum = 0;
        line:
        for (String splitLine : splitLines) {
            List<Integer> vals = new ArrayList<>();
            for (String s : splitLine.split("[^0-9]")) {
                int value = Integer.parseInt(s);
                vals.add(value);
            }
            for (int i = 0; i < vals.size(); i++) {
                int initalVal = vals.get(i);
                for (Integer val : vals) {
                    if (val == initalVal) {
                        continue;
                    }
                    if (initalVal % val == 0) {
                        checksum += initalVal / val;
                        continue line;
                    }
                }
            }
        }
        System.out.println(checksum);
    }

}
