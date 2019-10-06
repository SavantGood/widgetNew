package wid.widget;

import wid.widget.entity.Widget;

import java.util.Comparator;

public class SortedZindex implements Comparator<Widget> {
    @Override
    public int compare(Widget o1, Widget o2) {
        if (o1.getzIndex() > o2.getzIndex()) {
            return 1;
        } if (o1.getzIndex() < o2.getzIndex()) {
            return -1;
        }
            return 0;
    }
}
