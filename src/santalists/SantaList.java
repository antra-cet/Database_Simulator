package santalists;

import java.util.*;

public class SantaList {
    /**
     * The input's initial data meaning the children list
     * and the initial gifts that will be changed
     * if updated
     */
    private ArrayList<Children> children = new ArrayList<>();
    private ArrayList<Gifts> santaGiftsList = new ArrayList<>();

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
     * Finding the perfect gift for the child
     * @param gift the category in which it should be
     * @return the best gift for the child
     */
    public Gifts findGift(final String gift) {
        // Setting the two on standby values
        double price = -1;
        Gifts bestGift = null;

        // Iterating through the lst of gifts
        for (Gifts g : santaGiftsList) {
            if (Objects.equals(gift, g.getCategory()) && g.getQuantity() > 0) {
                // Changing the values if found a better gift
                if (price == -1) {
                    price = g.getPrice();
                    bestGift = g;
                } else if (price > g.getPrice()) {
                    price = g.getPrice();
                    bestGift = g;
                }
            }
        }

        return bestGift;
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

    public ArrayList<Children> getChildrenAfterId() {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(Children o1, Children o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        return newArr;
    }

    public ArrayList<Children> getChildrenAfterNiceScore() {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(Children o1, Children o2) {
                if (o1.getAverageScore() == o2.getAverageScore()) {
                    return Integer.compare(o1.getId(), o2.getId());
                }

                return (-1) * Double.compare(o1.getAverageScore(), o2.getAverageScore());
            }
        });

        return newArr;
    }

    public ArrayList<Children> getChildrenAfterNiceCityScore() {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(Children o1, Children o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        return newArr;
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
