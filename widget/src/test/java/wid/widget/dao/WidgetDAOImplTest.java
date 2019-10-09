package wid.widget.dao;

import org.junit.Assert;
import org.junit.Test;
import wid.widget.controller.WidgetController;
import wid.widget.entity.Widget;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WidgetDAOImplTest {
    WidgetDAOImpl wd = new WidgetDAOImpl();

    @Test
    public void list() {
        List<Widget> expected = wd.list();

        List<Widget> actual = new ArrayList<>();
        actual.add(wd.widget1);
        actual.add(wd.widget);
        actual.add(wd.widget2);

        Assert.assertEquals(expected.get(0), actual.get(0));
        Assert.assertEquals(expected.get(1), actual.get(1));
        Assert.assertEquals(expected.get(2), actual.get(2));
    }

    @Test
    public void list_Not_Null() {
        WidgetDAOImpl wd = new WidgetDAOImpl();
        List<Widget> expected = wd.list();
        Assert.assertNotNull(expected);
    }

    @Test
    public void delete () {
        wd.delete(wd.widget);
        List<Widget> expected = wd.list();
        List<Widget> actual = wd.list();
        actual.remove(wd.widget);

        Assert.assertEquals(expected, actual);

    }
}