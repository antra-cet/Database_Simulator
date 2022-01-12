package santahelpers.sortstrategy;

import santalists.Children;

import java.util.ArrayList;
import java.util.Comparator;

public class NiceScoreSortStrategy implements SortStrategy {

    /**
     * Sorts the children list after the nice scores
     * @param children the initial list
     * @return the sorted array
     */
    @Override
    public ArrayList<Children> sortChildren(final ArrayList<Children> children) {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(final Children o1, final Children o2) {
                if (o1.getAverageScore() == o2.getAverageScore()) {
                    return Integer.compare(o1.getId(), o2.getId());
                }

                return (-1) * Double.compare(o1.getAverageScore(),
                        o2.getAverageScore());
            }
        });

        return newArr;
    }
}
