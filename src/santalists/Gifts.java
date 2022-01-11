package santalists;

public class Gifts {
    /**
     * The gifts descriptions
     */
    private String productName;
    private double price;
    private String category;
    private int quantity;

    /**
     * Constructors
     **/
    public Gifts() {
    }

    public Gifts(String productName, double price, String category, int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    /**
     * Getters and Setters
     **/

    /**
     * Getter for product name
     * @return the name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Setter for product name
     * @param productName sets the name
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Getter for price
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price
     * @param price sets the price
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * Getter for category
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for category
     * @param category sets the category
     */
    public void setCategory(final String category) {
        this.category = category;
    }

    /**
     * Getter for quantity
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity
     * @param quantity sets the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "Gifts{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category='" + category + '\''
                + '}';
    }
}
