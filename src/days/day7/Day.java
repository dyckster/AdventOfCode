package days.day7;

import utils.Util;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day {
    private static final boolean USE_TEST = false;

    public static void main(String[] args) {
        String input = Util.readFromFile(Paths.get("input7" + (USE_TEST ? "test" : "") + ".txt"));
        ptOne(input);
    }

    private static List<String> parents = new ArrayList<>();
    private static List<String> children = new ArrayList<>();

    private static void ptOne(String input) {
        for (String s : input.split("\\n")) {
            System.out.println(s);
            Pattern pattern = Pattern.compile("(\\w*) \\((\\d*)\\)(?: -> (.*)?)?");
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String head = matcher.group(1);
                parents.add(head);
                String value = matcher.group(2);
                if (matcher.group(3) != null) {
                    String[] children = matcher.group(3).replace(",", "").split(" ");
                    Day.children.addAll(Arrays.asList(children));
                }
            }
        }
        System.out.println("Parents: " + parents.size());
        System.out.println("Children: " + children.size());

        HashSet<String> all = new HashSet<>(children);
        for (String parent : parents) {
            if (all.add(parent)) {
                System.out.println("Found the one: " + parent);
            }
        }

    }

    private static class Node {
        private String head;
        private String value;
        private String[] children;
    }
}
