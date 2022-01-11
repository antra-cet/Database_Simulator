package reader;

import santalists.Gifts;

public class GiftsOutput {
    /**
     * The gifts output descriptions
     */
    private String productName;
    private double price;
    private String category;

    /**
     * Constructors
     **/
    public GiftsOutput() {
    }

    public GiftsOutput(final Gifts gift) {
        this.productName = gift.getProductName();
        this.price = gift.getPrice();
        this.category = gift.getCategory();
    }

    public GiftsOutput(String productName, double price, String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
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
