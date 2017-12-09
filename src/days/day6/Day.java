package days.day6;

import java.util.*;

public class Day {

    private static final String ORIGINAL_INPUT = "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4";
    private static final String TEST_INPUT = "0\t2\t7\t0";

    private static boolean isTest = false;

    public static void main(String[] args) {
        String[] inputs = isTest ? TEST_INPUT.split("\t") : ORIGINAL_INPUT.split("\t");
        List<Integer> vals = new ArrayList<>();
        for (String input : inputs) {
            vals.add(Integer.parseInt(input));
        }

        taskOne(vals);
    }


    private static void taskOne(List<Integer> vals) {
        HashMap<String, Integer> historyMap = new HashMap<>();

        int currentBank = 0;
        int currentIndex = 0;
        int cycleCount = 0;
        do {
            System.out.println("current bank: " + currentBank);
            int currentVal = vals.get(currentIndex);
            if (currentBank == 0) {
                String his = vals.toString();
                Integer oldVal = historyMap.put(his, cycleCount);
                if (oldVal != null) {
                    System.out.println("Dif: " + (cycleCount - oldVal));
                    System.out.println("cycle count: " + cycleCount);
                    System.out.println("DONE");
                    System.exit(0);
                } else {
                    cycleCount++;

                }

                currentBank = Collections.max(vals);

                for (int i = 0; i < vals.size(); i++) {
                    if (vals.get(i) == currentBank) {
                        vals.set(i, 0);
                        if (i == vals.size() - 1) {
                            currentIndex = 0;
                        } else {
                            currentIndex = i + 1;
                        }
                        break;
                    }
                }
                continue;
            }
            vals.set(currentIndex, ++currentVal);
            --currentBank;

            if (currentIndex >= vals.size() - 1) {
                currentIndex = 0;
            } else {
                ++currentIndex;
            }
        } while (true);
    }

}
