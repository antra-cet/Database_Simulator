package main;

import common.Constants;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public final class Test {

    private Test() {
    }

    /**
     * Main function to check if the results are correct
     * The result is written in the test.txt file
     * @param args input files
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        File[] inputDir = directory.listFiles();

        if (inputDir != null) {
            Arrays.sort(inputDir);

            // Reading the test name
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.next();

            // Finding the file and calculating
            for (File file : inputDir) {
                if (file.getName().equalsIgnoreCase(fileName)) {
                    Main.sendGifts(file.getAbsolutePath(), Constants.OUT_FILE);
                    break;
                }
            }
        }
    }
}
