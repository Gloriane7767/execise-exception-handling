package com.gloriane.Exercise4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIntergerParse {
    public static void main(String[] args) {
        Path path = Paths.get("integers.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                try {
                    int value = Integer.parseInt(line.trim());
                    System.out.println("Parse Integer: " + value);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Could not parse '" + line + "' as an integer.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred: " + e.getMessage());
        }
    }
}
