package santalists;

import santahelpers.CitiesAverage;
import santahelpers.SortStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

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
     * Finding the perfect gift for an elf to give to a child
     * @param gift the category in which it should be
     * @return the best gift for the child given by the yellow elf
     */
    public Gifts findYellowGift(final String gift) {
        // Setting the two on standby values
        double price = -1;
        Gifts bestGift = null;

        // Iterating through the lst of gifts
        for (Gifts g : santaGiftsList) {
            if (Objects.equals(gift, g.getCategory())) {
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

    /**
     * Method to apply the strategy on the list of children
     * @param */
    public ArrayList<Children> sortChildren(final SortStrategy sortStrategy) {
        return sortStrategy.sortChildren(children);
    }

    /**
     * Creates a new array of children that are sorted after id
     * @return the sorted array
     */
    public ArrayList<Children> getChildrenAfterId() {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(final Children o1, final Children o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        return newArr;
    }

    /**
     * Creates a new array of children that are sorted after nice score
     * @return the sorted array
     */
    public ArrayList<Children> getChildrenAfterNiceScore() {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(final Children o1, final Children o2) {
                if (o1.getAverageScore() == o2.getAverageScore()) {
                    return Integer.compare(o1.getId(), o2.getId());
                }

                return (-1) * Double.compare(o1.getAverageScore(),
                        o2.getAverageScore());
            }
        });

        return newArr;
    }

    /**
     * Creates a new array of children that are sorted after nice
     * city score
     * @return the sorted array
     */
    public ArrayList<Children> getChildrenAfterNiceCityScore(final HashMap<String,
            CitiesAverage> citiesAverage) {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(final Children o1, final Children o2) {
                if (o1.getCity().equals(o2.getCity())) {
                    return Integer.compare(o1.getId(), o2.getId());
                }

                if (citiesAverage.get(o1.getCity().name()).getAverageScore()
                        == citiesAverage.get(o2.getCity().name()).getAverageScore()) {
                    return o1.getCity().name().compareTo(o2.getCity().name());
                }

                return (-1)
                        * Double.compare(citiesAverage.get(o1.getCity().name()).getAverageScore(),
                        citiesAverage.get(o2.getCity().name()).getAverageScore());
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
