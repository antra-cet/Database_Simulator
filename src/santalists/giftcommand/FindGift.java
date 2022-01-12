package santalists.giftcommand;

import santalists.Gifts;

import java.util.ArrayList;

public interface FindGift {

    /**
     * Returns the gift that should be assigned to a normal child
     */
    Gifts findNormal(String gift, ArrayList<Gifts> santasList);

    /**
     * Returns the gift that should be assigned to a child with
     * a yellow elf
     */
    Gifts findYellow(String gift, ArrayList<Gifts> santasList);
}
