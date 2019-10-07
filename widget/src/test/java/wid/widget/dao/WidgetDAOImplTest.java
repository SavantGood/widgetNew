package wid.widget.dao;

import org.junit.Assert;
import org.junit.Test;
import wid.widget.controller.WidgetController;
import wid.widget.entity.Widget;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WidgetDAOImplTest {

    @Test
    public void list() {
        WidgetDAOImpl wd = new WidgetDAOImpl();


        List<Widget> expected = wd.list();

        List<Widget> actual = new ArrayList<>();
        actual.add(wd.widget1);
        actual.add(wd.widget);
        actual.add(wd.widget2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void list_Not_Null() {
        WidgetDAOImpl wd = new WidgetDAOImpl();
        List<Widget> expected = wd.list();
        Assert.assertNotNull(expected);
    }
}