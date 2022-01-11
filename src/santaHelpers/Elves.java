package santahelpers;

import common.Constants;
import santalists.Children;

public class Elves {
    private String type;

    /**
     * Constructors
     */
    public Elves() {
    }

    public Elves(final String type) {
        this.type = type;
    }

    /**
     * Getters and Setters
     */

    /**
     * Getter for type
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type
     * @param type to set the type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Additional methods
     */

    /**
     * A static method that returns the assigned budget for a child
     * based on the child's type of elf
     */
    public static double pickElfAverage(final Children child, final double budgetUnit) {
        return switch (child.getElf().getType()) {
            case "pink" -> pinkElf(child.getAverageScore(), budgetUnit);
            case "black" -> blackElf(child.getAverageScore(), budgetUnit);
            default -> whiteElf(child.getAverageScore(), budgetUnit);
        };
    }

    /**
     * A static method that returns the assigned budget for a child
     * with a pink elf
     */
    public static double pinkElf(final double average, final double budgetUnit) {
        double budget = average * budgetUnit;
        budget = budget + budget * Constants.ELF_PERCENTAGE / Constants.PERCENT;

        return budget;
    }

    /**
     * A static method that returns the assigned budget for a child
     * with a black elf
     */
    public static double blackElf(final double average, final double budgetUnit) {
        double budget = average * budgetUnit;
        budget = budget - budget * Constants.ELF_PERCENTAGE / Constants.PERCENT;

        return budget;
    }

    /**
     * A static method that returns the assigned budget for a child
     * with a white elf
     */
    public static double whiteElf(final double average, final double budgetUnit) {
        return average * budgetUnit;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "Elves{"
                + "type='" + type + '\''
                + '}';
    }
}
