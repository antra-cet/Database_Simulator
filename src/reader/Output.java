package reader;

import java.util.ArrayList;

public class Output {
    /**
     * The class describing the structure of the output containing
     * annualChildren which is a list describing each year's lists of children
     */
    private ArrayList<ChildrenOutputList> annualChildren = new ArrayList<>();

    /**
     * Constructors
     **/
    public Output() {
    }
    public Output(final ArrayList<ChildrenOutputList> annualChildren) {
        this.annualChildren = annualChildren;
    }

    /**
     * Getters and Setters
     **/

    /**
     * Getter for annual children
     * @return annual children
     */
    public ArrayList<ChildrenOutputList> getAnnualChildren() {
        return annualChildren;
    }

    /**
     * Setter for annual children
     * @param annualChildren sets the children list
     */
    public void setAnnualChildren(final ArrayList<ChildrenOutputList> annualChildren) {
        this.annualChildren = annualChildren;
    }

    /**
     * Additional methods
     **/

    /**
     * Returning the list of children from a cretain year
     * @param index the year index*/
    public ChildrenOutputList getIthYear(final int index) {
        return annualChildren.get(index);
    }

    /**
     * Adding a new children output list to the annual children
     * @param newChildrenList the new children list that is added
     */
    public void addYear(final ChildrenOutputList newChildrenList) {
        annualChildren.add(newChildrenList);
    }

    /**
     * toString
     **/
    @Override
    public String toString() {
        return "Output{"
                + "annualChildren=" + annualChildren
                + '}';
    }
}
