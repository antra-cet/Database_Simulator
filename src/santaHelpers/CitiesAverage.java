package santahelpers;

import java.util.ArrayList;
import java.util.HashMap;

public class CitiesAverage {
    private ArrayList<Double> scoresList = new ArrayList<>();
    private double averageScore;

    /**
     * Constructors
     */
    public CitiesAverage() {
    }

    /**
     * Builder design to minimize the given parameters
     */
    public static class CityBuilder {
        private ArrayList<Double> scoresList = new ArrayList<>(); // optional
        private double averageScore; // optional

        public CityBuilder(final ArrayList<Double> scoresList1) {
            this.scoresList = scoresList1;
        }

        /**
         * Adds the average score
         */
        public CityBuilder addScore(final double averageScore1) {
            this.averageScore = averageScore1;
            return this;
        }

        /**
         * Builds the element
         */
        public CitiesAverage build() {
            return new CitiesAverage(this);
        }
    }

    /**
     * Private constructor
     */
    public CitiesAverage(final CityBuilder builder) {
        this.averageScore = builder.averageScore;
        this.scoresList = builder.scoresList;
    }

    /**
     * Getters and Setters
     */

    /**
     * Getter for scores
     * @return the scores
     */
    public ArrayList<Double> getScoresList() {
        return scoresList;
    }

    /**
     * Setter for scores
     * @param scoresList to set the scores
     */
    public void setScoresList(final ArrayList<Double> scoresList) {
        this.scoresList = scoresList;
    }

    /**
     * Getter for score
     * @return the score
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * Setter for score
     * @param averageScore to set the score
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * Additional methods
     */
    public void calculateAverage() {
        if (scoresList.size() == 0) {
            averageScore = 0;
            return;
        }

        double sum = 0;
        for (Double d : scoresList) {
            sum += d;
        }

        averageScore = sum / scoresList.size();
    }

    /**
     * Calculates all the average scores for each city based
     * on the array of nice scores
     */
    public static void calculateAllScores(final HashMap<String, CitiesAverage> arr) {
        for (String key : arr.keySet()) {
            arr.get(key).calculateAverage();
        }
    }

    /**
     * Adds new score in the array list
     */
    public void addScore(final double score) {
        scoresList.add(score);
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "CitiesAverage{"
                + "scoresList=" + scoresList
                + ", averageScore=" + averageScore
                + '}';
    }
}
