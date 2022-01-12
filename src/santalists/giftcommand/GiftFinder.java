package santalists.giftcommand;

import santalists.Gifts;

import java.util.ArrayList;
import java.util.Objects;

public class GiftFinder implements FindGift {

    /**
     * Finding the perfect gift for the child
     * @param gift the category in which it should be
     * @param santaGiftsList santa's gifts list
     * @return the best gift for the child
     */
    @Override
    public Gifts findNormal(final String gift, final ArrayList<Gifts> santaGiftsList) {
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
     * @param santaGiftsList the list of gifts
     * @return the best gift for the child given by the yellow elf
     */
    @Override
    public Gifts findYellow(final String gift, final ArrayList<Gifts> santaGiftsList) {
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

        if (bestGift.getQuantity() <= 0) {
            return null;
        }
        return bestGift;
    }
}
