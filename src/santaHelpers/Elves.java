package santaHelpers;

public class Elves {
    private String type;

    /**
     * Constructors
     */
    public Elves() {
    }

    public Elves(String type) {
        this.type = type;
    }

    /**
     * Getters and Setters
     */

    /**
     * Getter for type
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type
     * @param type to set the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "Elves{" +
                "type='" + type + '\'' +
                '}';
    }
}
