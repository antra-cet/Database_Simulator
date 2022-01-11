package reader;

import santalists.Changes;
import santalists.Children;
import santalists.ChildrenUpdates;
import santalists.SantaList;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Input implements Observer {
    /**
     * An observer that remembers all the fields given as input
     * and also serves as the database remembering and updating
     * the data
     */
    private long numberOfYears;
    private double santaBudget;
    private SantaList initialData;
    private ArrayList<Changes> annualChanges;

    /**
     * Constructors
     **/
    public Input() {
    }

    public Input(final long numberOfYears, final double santaBudget,
                 final SantaList initialData, final ArrayList<Changes> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    /**
     * Getters and Setters
     **/

    /**
     * Getter for number of years
     * @return the number of years
     */
    public long getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Setter for number of years
     * @param numberOfYears sets the years
     */
    public void setNumberOfYears(final long numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Getter for number of santa budget
     * @return the budget
     */
    public double getSantaBudget() {
        return santaBudget;
    }

    /**
     * Setter for santa budget
     * @param santaBudget sets the budget
     */
    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * Getter for initial data
     * @return the data
     */
    public SantaList getInitialData() {
        return initialData;
    }

    /**
     * Setter for initial data
     * @param initialData sets the data
     */
    public void setInitialData(final SantaList initialData) {
        this.initialData = initialData;
    }

    /**
     * Getter for annual changes
     * @return the changes
     */
    public ArrayList<Changes> getAnnualChanges() {
        return annualChanges;
    }

    /**
     * Setter for annual changes
     * @param annualChanges sets the changes
     */
    public void setAnnualChanges(final ArrayList<Changes> annualChanges) {
        this.annualChanges = annualChanges;
    }


    /**
     * Additional methods
     **/

    /**
     * The update method updates the budget and all the other
     * possible annual changes
     * @param o the observable
     * @param arg the changes that will be applied
     */
    @Override
    public void update(final Observable o, final Object arg) {
        if (arg instanceof Changes) {
            // Changing the budget and for the other lists verifying
            // if they contain a change
            santaBudget = ((Changes) arg).getNewSantaBudget();

            if (!((Changes) arg).getNewGifts().isEmpty()) {
                initialData.addNewGifts(((Changes) arg).getNewGifts());
            }

            if (!((Changes) arg).getNewChildren().isEmpty()) {
                for (Children c : ((Changes) arg).getNewChildren()) {
                    initialData.addNewChildren(c);
                }
            }

            if (!((Changes) arg).getChildrenUpdates().isEmpty()) {
                for (ChildrenUpdates c : ((Changes) arg).getChildrenUpdates()) {
                    if (initialData.getChildAfterId(c.getId()) != null) {
                        initialData.getChildAfterId(c.getId()).update(c);
                    }
                }
            }
        }
    }

    /**
     * toString
     **/
    @Override
    public String toString() {
        return "Input{"
                + "numberOfYears=" + numberOfYears
                + ", santaBudget=" + santaBudget
                + ", initialData=" + initialData
                + ", annualChanges=" + annualChanges
                + '}';
    }
}
