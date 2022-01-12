package santalists.giftcommand;

import santalists.Gifts;

import java.util.ArrayList;

public class FindYellowElfGiftCommand implements Command {
    private FindGift findGift;

    public FindYellowElfGiftCommand(final FindGift findGift) {
        this.findGift = findGift;
    }

    /**
     * Execute the find yellow gift method to return the gift
     */
    @Override
    public Gifts execute(final String gift, final ArrayList<Gifts> santaGiftsList) {
        return findGift.findYellow(gift, santaGiftsList);
    }
}
