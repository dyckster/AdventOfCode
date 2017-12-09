package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Util {
    public static String readFromFile(Path path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader r = Files.newBufferedReader(path)) {
            r.lines().forEach(line -> builder.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
