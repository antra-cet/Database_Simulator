package santahelpers;

import santalists.Children;

import java.util.ArrayList;
import java.util.Comparator;

public class IdSortStrategy implements SortStrategy{
    @Override
    public ArrayList<Children> sortChildren(ArrayList<Children> children) {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(final Children o1, final Children o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        return newArr;
    }
}
