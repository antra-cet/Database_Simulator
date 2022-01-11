package reader;

import enums.Cities;
import santalists.Children;
import santalists.Gifts;

import java.util.ArrayList;

public class ChildrenOutput {

    /**
     * The class describing the structure of the output
     for children
     */
    private int id;
    private String lastName, firstName;
    private Cities city;
    private int age;
    private ArrayList<String> giftsPreferences;
    private double averageScore;
    private ArrayList<Double> niceScoreHistory;
    private double assignedBudget;
    private ArrayList<GiftsOutput> receivedGifts = new ArrayList<>();

    /**
     * Constructors
     **/
    public ChildrenOutput(final Children child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.age = child.getAge();
        this.giftsPreferences = child.getGiftsPreferences();
        this.averageScore = child.getAverageScore();
        this.niceScoreHistory = child.getNiceScore();
    }

    public ChildrenOutput(final Children child, final double assignedBudget) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.age = child.getAge();
        this.giftsPreferences = new ArrayList<>(child.getGiftsPreferences());
        this.averageScore = child.getAverageScore();
        this.niceScoreHistory = new ArrayList<>(child.getNiceScore());
        this.assignedBudget = assignedBudget;
    }

    public ChildrenOutput(final Children child, final ArrayList<GiftsOutput> receivedGifts) {
        this(child);
        child.calculateAverageNiceScore();
        this.averageScore = child.getAverageScore();
        this.receivedGifts = receivedGifts;
    }

    /**
     * Getters and Setters
     **/

    /**
     * Getter for id
     * @return the id of a child
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
     * @return the last name of a child
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
     * Getter for first name
     * @return the first name of a child
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
     * Getter for the city
     * @return the city of a child
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
     * Getter for age
     * @return the age of a child
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
     * Getter for gifts
     * @return the preferences of a child
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Setter for gifts preferences list
     * @param giftsPreferences sets the list
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * Getter for average score
     * @return the average nice score of a child
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * Setter for average score
     * @param averageScore sets the average
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * Getter for the nice score list
     * @return the nice scores of a child
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * Setter for nice score list
     * @param niceScoreHistory sets the list
     */
    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * Getter for assigned budget
     * @return the assigned budget of a child
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * Setter for assigned budget
     * @param assignedBudget sets the budget
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * Getter for received gifts
     * @return the gifts received by a child
     */
    public ArrayList<GiftsOutput> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * Setter for received gifts list
     * @param receivedGifts sets the list
     */
    public void setReceivedGifts(final ArrayList<GiftsOutput> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }


    /**
     * Additional methods
     **/

    /**
     * The method which adds a gift to the received gift list
     * @param gift the gift that is to be added
     */
    public void addReceivedGifts(final GiftsOutput gift) {
        receivedGifts.add(gift);
    }


    /**
     * toString
     **/
    @Override
    public String toString() {
        return "ChildrenOutput{"
                + "id=" + id
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", city=" + city
                + ", age=" + age
                + ", giftsPreferences=" + giftsPreferences
                + ", averageScore=" + averageScore
                + ", niceScoreHistory=" + niceScoreHistory
                + ", assignedBudget=" + assignedBudget
                + ", receivedGifts=" + receivedGifts
                + '}';
    }
}
