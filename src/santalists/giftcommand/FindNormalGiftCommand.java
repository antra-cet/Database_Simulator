package santalists.giftcommand;

import santalists.Gifts;

import java.util.ArrayList;

public class FindNormalGiftCommand implements Command {
    private FindGift findGift;

    public FindNormalGiftCommand(final FindGift findGift) {
        this.findGift = findGift;
    }

    /**
     * Execute the find gift method to return the gift
     */
    @Override
    public Gifts execute(final String gift, final ArrayList<Gifts> santaGiftsList) {
        return findGift.findNormal(gift, santaGiftsList);
    }
}
