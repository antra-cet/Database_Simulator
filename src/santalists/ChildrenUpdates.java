package santalists;

import santaHelpers.Elves;

import java.util.ArrayList;

public class ChildrenUpdates {
    /**
     * The updates for annual change
     */
    private int id;
    private Double niceScore;
    private ArrayList<String> giftsPreferences = new ArrayList<>();
    private Elves elf;

    /**
     * Constructors
     **/
    public ChildrenUpdates() {
    }

    public ChildrenUpdates(int id, Double niceScore, ArrayList<String> giftsPreferences, Elves elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    /**
     * Getters and Setters
     **/

    /**
     * Getter for id
     * @return id of a child
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
     * Getter for nice scores
     * @return the scores
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * Setter for nice scores
     * @param niceScore sets the scores
     */
    public void setNiceScore(final Double niceScore) {
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
     * Getter for elf
     * @return the type of elf
     */
    public Elves getElf() {
        return elf;
    }

    /**
     * Setter for elf
     * @param elf sets the type of elf
     */
    public void setElf(final Elves elf) {
        this.elf = elf;
    }

    /**
     * toString
     **/
    @Override
    public String toString() {
        return "ChildrenUpdates{"
                + "id=" + id
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + ", elf=" + elf
                + '}';
    }
}
