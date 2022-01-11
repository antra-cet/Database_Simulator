package main;

import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import reader.ChildrenOutput;
import reader.ChildrenOutputList;
import reader.Input;
import reader.Output;
import santalists.Changes;
import santalists.Children;
import santalists.Gifts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(Constants.TESTS_PATH);

        // Creating the output directory
        File outputDirectory = new File(Constants.OUTPUT_DIR);
        outputDirectory.mkdir();

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            // Creating the out file
            String index = file.getName().substring(Constants.TEST_LENGTH,
                    file.getName().length() - Constants.JSON_LENGTH);
            File outFile = new File(outputDirectory.getAbsolutePath() + "/out" + "_"
                    + index + Constants.FILE_EXTENSION);

            // Calling the function that calculates the output
            boolean isCreated = outFile.createNewFile();
            if (isCreated) {
                sendGifts(file.getAbsolutePath(), outFile.getAbsolutePath());
            }
        }

        // Calling the checker
        Checker.calculateScore();
    }

    /**
     * This method is used to call the checker which calculates the score
     * @param inPath is the absolute path to the input test files
     * @param outPath the absolute path to the output file to write
     *                the results
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void sendGifts(final String inPath, final String outPath) throws IOException {
        // Reading the input
        Input input = null;
        try {
            ObjectMapper inObjectMapper = new ObjectMapper();
            input = inObjectMapper.readValue(new File(inPath), Input.class);
        } catch (IOException ignored) {
        }

        if (input == null) {
            return;
        }

        // Preparing the output
        ObjectMapper outObjectMapper = new ObjectMapper();
        Output output = new Output();

        // Iterating through years
        for (int i = 0; i <= input.getNumberOfYears(); i++) {
            // Calculating santa's budget for each child
            double budgetUnit;
            double averageSum = 0.0;

            // Creating the new list for that year
            output.addYear(new ChildrenOutputList());

            // Iterating through children to calculate the average scores and
            // to remove the young adults
            for (int j = 0; j < input.getInitialData().getChildren().size(); j++) {
                Children c = input.getInitialData().getChildren().get(j);
                c.setAgeCategory();

                if (Objects.equals(c.getAgeCategory(), "Young Adult")) {
                    input.getInitialData().removeYoungAdult(j);
                    j--;
                } else {
                    c.calculateAverageNiceScore();
                    averageSum += c.getAverageScore();
                }
            }
            budgetUnit = input.getSantaBudget() / averageSum;

            // Iterating again through children and making the necessary changes
            for (Children c : input.getInitialData().getChildren()) {
                // Calculating the assigned budget for each child
                double assignedBudget = c.getAverageScore() * budgetUnit;

                // Creating a new child of type ChildrenOutput
                ChildrenOutput newChild = new ChildrenOutput(c, assignedBudget);

                // Making their list of received gifts
                for (String giftCategory : c.getGiftsPreferences()) {
                    // Verifying if they still have enough money
                    if (assignedBudget > 0) {
                        // Finding the assigned gift for the child
                        Gifts newGift = input.getInitialData().findGift(giftCategory);
                        if (newGift != null && assignedBudget > newGift.getPrice()) {
                            newChild.addReceivedGifts(newGift);
                            assignedBudget -= newGift.getPrice();
                        }
                    } else {
                        break;
                    }
                }

                // Adding the children to the output list and incrementing
                // the children ages
                output.getIthYear(i).addListOfChildren(newChild);
                c.updateAge();
            }

            // Updating the input
            if (input.getAnnualChanges().size() > i) {
                // Creating the observers
                Changes observable = input.getAnnualChanges().get(i);
                observable.addObserver(input);
                observable.notify(input.getAnnualChanges().get(i));
            }
        }

        // Writing the value in the output file
        outObjectMapper.writeValue(new File(outPath), output);
    }
}