package santahelpers;

import santalists.Children;

import java.util.ArrayList;
import java.util.Comparator;

public class NiceScoreSortStrategy implements SortStrategy{
    @Override
    public ArrayList<Children> sortChildren(ArrayList<Children> children) {
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
