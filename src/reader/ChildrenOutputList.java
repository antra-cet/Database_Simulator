package reader;

import java.util.ArrayList;

public class ChildrenOutputList {

    /**
     * The list of children that appears within the annual children list
     */
    private ArrayList<ChildrenOutput> children = new ArrayList<>();

    /**
     * Constructors
     */
    public ChildrenOutputList() {
    }

    public ChildrenOutputList(final ArrayList<ChildrenOutput> children) {
        this.children = children;
    }

    /**
     * Getters and Setters
     */

    /**
     * Getter for children list
     * @return the children list
     */
    public ArrayList<ChildrenOutput> getChildren() {
        return children;
    }

    /**
     * Setter for children list
     * @param children sets the list
     */
    public void setChildren(final ArrayList<ChildrenOutput> children) {
        this.children = children;
    }


    /**
     * Additional methods
     **/

    /**
     * Adds a child to the children list
     * @param childrenOutput the child to be added
     */
    public void addListOfChildren(final ChildrenOutput childrenOutput) {
        children.add(childrenOutput);
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "ChildrenOutputList{"
                + "children=" + children
                + '}';
    }
}