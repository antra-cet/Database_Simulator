package santalists.giftcommand;

import santalists.Gifts;

import java.util.ArrayList;

public interface Command {

    /**
     * The execution command
     */
    Gifts execute(String gift, ArrayList<Gifts> santaGiftsList);
}
