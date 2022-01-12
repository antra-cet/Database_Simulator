package santalists;

import santahelpers.sortstrategy.SortStrategy;
import santalists.giftcommand.Command;

import java.util.ArrayList;

public class SantaList {
    /**
     * The input's initial data meaning the children list
     * and the initial gifts that will be changed
     * if updated
     */
    private ArrayList<Children> children = new ArrayList<>();
    private ArrayList<Gifts> santaGiftsList = new ArrayList<>();

    /**
     * The two commands
     */
    private Command normalGiftCommand;
    private Command yellowGiftCommand;

    public SantaList(final Command normalGiftCommand, final Command yellowGiftCommand) {
        this.normalGiftCommand = normalGiftCommand;
        this.yellowGiftCommand = yellowGiftCommand;
    }

    /**
     * Constructors
     **/
    public SantaList() {
    }

    public SantaList(final ArrayList<Children> children, final ArrayList<Gifts> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    /**
     * Getters and Setters
     **/

    /**
     * Getter for children list
     * @return the list
     */
    public ArrayList<Children> getChildren() {
        return children;
    }

    /**
     * Setter for children list
     * @param children sets the list
     */
    public void setChildren(final ArrayList<Children> children) {
        this.children = children;
    }

    /**
     * Getter for santa's gift list
     * @return the list
     */
    public ArrayList<Gifts> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * Setter for santa's gift list
     * @param santaGiftsList sets the list
     */
    public void setSantaGiftsList(final ArrayList<Gifts> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    /**
     * Additional methods
     **/

    /**
     * Adds a new child to the children list
     * @param newChildren the new child to be added
     */
    public void addNewChildren(final Children newChildren) {
        children.add(newChildren);
    }

    /**
     * Adding new gifts to the gift list
     * @param newGifts the new array of gits to be added with the update
     */
    public void addNewGifts(final ArrayList<Gifts> newGifts) {
        // Creating the new list
        ArrayList<Gifts> newGiftPreferences = new ArrayList<>();

        // Adding the gifts one by one verifying each time that
        // there are no doubles
        for (Gifts gifts : newGifts) {
            if (!newGiftPreferences.contains(gifts)) {
                newGiftPreferences.add(gifts);
            }
        }

        for (Gifts gifts : this.santaGiftsList) {
            if (!newGiftPreferences.contains(gifts)) {
                newGiftPreferences.add(gifts);
            }
        }

        // Updating the old gift list
        this.santaGiftsList = newGiftPreferences;
    }

    /**
     * Removing a young adult from the list
     * @param index the index at which the young adult is on
     */
    public void removeYoungAdult(final int index) {
        children.remove(index);
    }

    /**
     * Applying the command pattern
     */

    /**
     * Finding the gift for a normal child
     */
    public Gifts findGift(final String gift,  final ArrayList<Gifts> santaGiftsList1) {
        return this.normalGiftCommand.execute(gift, santaGiftsList1);
    }

    /**
     * Finding a gift for a child with a yellow elf
     */
    public Gifts findYellowGift(final String gift,  final ArrayList<Gifts> santaGiftsList1) {
        return this.yellowGiftCommand.execute(gift, santaGiftsList1);
    }

    /**
     * Returning a child after its id
     * @param id the id of the child
     * @return the child if found or null if not
     */
    public Children getChildAfterId(final int id) {
        for (Children c : children) {
            if (c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    /**
     * Method to apply the strategy on the list of children
     * @param sortStrategy to show which type of sort should
     * be applied
     */
    public ArrayList<Children> sortChildren(final SortStrategy sortStrategy) {
        return sortStrategy.sortChildren(children);
    }

    /**
     * toString
     **/
    @Override
    public String toString() {
        return "SantaList{"
                + "children=" + children
                + ", santaGiftsList=" + santaGiftsList
                + '}';
    }
}
