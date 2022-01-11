package santalists;

import common.Constants;
import enums.Cities;
import santahelpers.Elves;

import java.util.ArrayList;
import java.util.Objects;

public class Children {
    /**
     * The children class describes each child
     * with its descriptors
     **/
    private int id;
    private String lastName, firstName;
    private int age;
    private Cities city;
    private ArrayList<Double> niceScore = new ArrayList<>();
    private ArrayList<String> giftsPreferences = new ArrayList<>();
    private double niceScoreBonus;
    private Elves elf;

    /**
     * Additional descriptors
     **/
    private double averageScore = Constants.START_AVERAGE_SCORE;
    private String ageCategory;

    /**
     * Constructors
     **/
    public Children() {
    }

    public Children(final int id, final String lastName, final String firstName,
                    final int age, final Cities city,
                    final ArrayList<Double> niceScore, final ArrayList<String> giftsPreferences,
                    final double niceScoreBonus, final Elves elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
    }

    /**
     * Getters and setters
     **/

    /**
     * Getter for id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id
     * @param id sets the id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Getter for last name
     * @return the name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for last name
     * @param lastName sets the name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for last name
     * @return the name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for first name
     * @param firstName sets the name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for age
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for age
     * @param age sets the age
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * Getter for city
     * @return the city
     */
    public Cities getCity() {
        return city;
    }

    /**
     * Setter for city
     * @param city sets the city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * Getter for nice score
     * @return the scores
     */
    public ArrayList<Double> getNiceScore() {
        return niceScore;
    }

    /**
     * Setter for nice scores
     * @param niceScore sets the list
     */
    public void setNiceScore(final ArrayList<Double> niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * Getter for gift preferences
     * @return the list
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Setter for gift preferences
     * @param giftsPreferences sets the list
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * Getter for average score
     * @return score
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * Getter for average score
     * @param averageScore sets the score
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * Getter for age category
     * @return age category
     */
    public String getAgeCategory() {
        return ageCategory;
    }

    /**
     * Getter for nice score bonus
     * @return score bonus
     */
    public double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * Setter for nice score bonus
     * @param niceScoreBonus score bonus
     */
    public void setNiceScoreBonus(final double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    /**
     * Getter for elf
     * @return the elf
     */
    public Elves getElf() {
        return elf;
    }

    /**
     * Setter for elf
     * @param elf the elf
     */
    public void setElf(final Elves elf) {
        this.elf = elf;
    }

    /**
     * Additional methods
     **/

    /** Updates the children descriptions
     @param arg : the object containing the updates
     **/
    public void update(final Object arg) {
        // Verifies if the id matches the child's id
        if (((ChildrenUpdates) arg).getId() != id) {
            return;
        }

        // Verification if some descriptions are null
        if (((ChildrenUpdates) arg).getNiceScore() != null) {
            this.setNiceScore(((ChildrenUpdates) arg).getNiceScore());
            calculateAverageNiceScore();
        }

        if (!((ChildrenUpdates) arg).getGiftsPreferences().isEmpty()) {
            updateGiftPreferences(((ChildrenUpdates) arg).getGiftsPreferences());
        }

        if (((ChildrenUpdates) arg).getElf() != null) {
            this.setElf(((ChildrenUpdates) arg).getElf());
        }
    }

    /**
     * Adds a nice score to the nice score history list
     * @param niceScore the score to be added
     */
    public void setNiceScore(final double niceScore) {
        this.niceScore.add(niceScore);
    }

    /**
     * Sets the age category for the child
     */
    public void setAgeCategory() {
        if (age < Constants.BABY_AGE) {
            ageCategory = "Baby";
        } else if (age < Constants.KID_AGE) {
            ageCategory = "Kid";
        } else if (age <= Constants.TEEN_AGE) {
            ageCategory = "Teen";
        } else {
            ageCategory = "Young Adult";
        }
    }

    /**
     * For each age category calculates the average score
     * based on the nice scores up until that point
     */
    public void calculateAverageNiceScore() {
        // All babies have a 10
        if (Objects.equals(ageCategory, "Baby")) {
            averageScore = Constants.START_AVERAGE_SCORE;
            return;
        }

        // Arithmetical average for the kids
        if (Objects.equals(ageCategory, "Kid")) {
            double sum = 0;

            for (Double s : niceScore) {
                sum += s;
            }

            averageScore = sum / niceScore.size();

            // Verify if there is no niceScoreBonus
            if (niceScoreBonus == 0) {
                return;
            }

            // Calculate the average score after applying the bonus
            averageScore += (averageScore * niceScoreBonus) / Constants.PERCENT;

            // Setting the score to 10 if it exceeds it
            if (averageScore > Constants.START_AVERAGE_SCORE) {
                averageScore = Constants.START_AVERAGE_SCORE;
            }
            return;
        }

        // Weight average for teens
        if (Objects.equals(ageCategory, "Teen")) {
            double numerator = 0.0;
            double denominator = 0.0;

            for (int weight = 1; weight <= niceScore.size(); weight++) {
                numerator += weight;
                denominator += niceScore.get(weight - 1) * weight;
            }

            averageScore = denominator / numerator;

            // Verify if there is no niceScoreBonus
            if (niceScoreBonus == 0) {
                return;
            }

            // Calculate the average score after applying the bonus
            averageScore += (averageScore * niceScoreBonus) / Constants.PERCENT;

            // Setting the score to 10 if it exceeds it
            if (averageScore > Constants.START_AVERAGE_SCORE) {
                averageScore = Constants.START_AVERAGE_SCORE;
            }
            return;
        }

        // Young adults are removed from the list
        if (Objects.equals(ageCategory, "Young Adult")) {
            averageScore = -1;
        }
    }

    /**
     * It adds the new gift preferences for that year, not
     * repeating the older ones
     */
    public void updateGiftPreferences(final ArrayList<String> newGifts) {
        // Creating the new list
        ArrayList<String> newGiftPreferences = new ArrayList<>();

        // Verifying before each add if the element is already
        // in the list
        for (String gifts : newGifts) {
            if (!newGiftPreferences.contains(gifts)) {
                newGiftPreferences.add(gifts);
            }
        }

        for (String gifts : giftsPreferences) {
            if (!newGiftPreferences.contains(gifts)) {
                newGiftPreferences.add(gifts);
            }
        }

        // Updating the old gift preferences
        giftsPreferences = newGiftPreferences;
    }

    /**
     * It increments the age
     */
    public void updateAge() {
        age++;
    }

    /**
     * toString
     **/
    @Override
    public String toString() {
        return "Children{"
                + "id=" + id
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", age=" + age
                + ", city=" + city
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + ", niceScoreBonus=" + niceScoreBonus
                + ", elf=" + elf
                + ", averageScore=" + averageScore
                + ", ageCategory='" + ageCategory + '\''
                + '}';
    }
}
