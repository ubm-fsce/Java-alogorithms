package dsapractise.epi.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {

    public enum Color {
        red, white, blue
    }

    public static void main(String[] args) {
        List<Color> c = new ArrayList<>();
        c.add(Color.blue);
        c.add(Color.red);
        c.add(Color.white);
        c.add(Color.white);
        c.add(Color.red);
        c.add(Color.blue);
        c.add(Color.red);
        c.add(Color.white);
        c.add(Color.white);
        c.add(Color.red);
        List<Color> clrs = dutchFlagPartition(Color.white.ordinal(), c);
        System.out.println(clrs);
    }

    public static List<Color> dutchFlagPartition(int pivotIndex, List<Color> colors) {
        Color pivot = colors.get(pivotIndex);
        for (int i = 0; i < colors.size(); ++i) {
            for (int j = i + 1; j < colors.size(); ++j) {
                if (colors.get(j).ordinal() < pivot.ordinal()) {
                    Collections.swap(colors, i, j);
                    break;
                }
            }
        }
        for (int i = colors.size() - 1; i >= 0; --i) {
            for (int j = i - 1; j >= 0; j--) {
                if (colors.get(j).ordinal() > pivot.ordinal()) {
                    Collections.swap(colors, i, j);
                    break;
                }
            }
        }
        return colors;
    }

}
