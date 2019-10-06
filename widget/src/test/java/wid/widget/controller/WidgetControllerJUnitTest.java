package wid.widget.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import wid.widget.entity.Widget;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class WidgetControllerJUnitTest {

    @Test
    public void list() {
        WidgetController wc = new WidgetController();

        List<Widget> expected = wc.list();

        List<Widget> actual = new ArrayList<>();
        actual.add(wc.widget1);
        actual.add(wc.widget);
        actual.add(wc.widget2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void list_Not_Null() {
        WidgetController wc = new WidgetController();
        List<Widget> expected = wc.list();
        Assert.assertNotNull(expected);
    }


    @Test
    public void getOne() {
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}