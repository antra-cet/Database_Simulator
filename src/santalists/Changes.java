package santalists;

import java.util.ArrayList;
import java.util.Observable;

public class Changes extends Observable {
    /**
     * The class containing the changes applied for each year
     */
    private double newSantaBudget;
    private ArrayList<Gifts> newGifts;
    private ArrayList<Children> newChildren;
    private ArrayList<ChildrenUpdates> childrenUpdates;
    private String strategy;

    /**
     * Constructors
     **/
    public Changes() {
    }

    public Changes(double newSantaBudget, ArrayList<Gifts> newGifts,
                   ArrayList<Children> newChildren,
                   ArrayList<ChildrenUpdates> childrenUpdates, String strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }

    /**
     * Getters and Setters
     **/

    /**
     * Getter for new santa budget
     * @return the budget
     */
    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * Setter for new santa budget
     * @param newSantaBudget sets the budget
     */
    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     * Getter for new gifts
     * @return the gifts
     */
    public ArrayList<Gifts> getNewGifts() {
        return newGifts;
    }

    /**
     * Setter for new gifts
     * @param newGifts sets the gifts
     */
    public void setNewGifts(final ArrayList<Gifts> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * Getter for new children
     * @return the children
     */
    public ArrayList<Children> getNewChildren() {
        return newChildren;
    }

    /**
     * Setter for new children
     * @param newChildren sets the children
     */
    public void setNewChildren(final ArrayList<Children> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * Getter for new updates on children
     * @return the updates
     */
    public ArrayList<ChildrenUpdates> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * Setter for new children updates
     * @param childrenUpdates sets the children updates
     */
    public void setChildrenUpdates(final ArrayList<ChildrenUpdates> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    /**
     * Getter for new strategy
     * @return the strategy
     */
    public String getStrategy() {
        return strategy;
    }

    /**
     * Setter for new strategy
     * @param strategy sets the strategy
     */
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    /**
     * Additional methods
     **/

    /**
     * The observable method that notifies its observers
     * @param arg the changes that are to be applied
     */
    public void notify(final Object arg) {
        setChanged();
        notifyObservers(arg);
    }

    /**
     * toString
     **/
    @Override
    public String toString() {
        return "Changes{"
                + "newSantaBudget=" + newSantaBudget
                + ", newGifts=" + newGifts
                + ", newChildren=" + newChildren
                + ", childrenUpdates=" + childrenUpdates
                + ", strategy='" + strategy + '\''
                + '}';
    }
}
