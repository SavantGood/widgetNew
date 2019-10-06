package wid.widget.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import wid.widget.dao.WidgetDAO;
import wid.widget.dao.WidgetDAOImpl;
import wid.widget.entity.Widget;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class WidgetControllerJUnitTest {

    @Test
    public void list() {
        WidgetController wc = new WidgetController();
        Widget widget = new Widget(1, 10, 10);
        Widget widget1 = new Widget(0, 15, 15);
        Widget widget2 = new Widget(2, 20, 20);


        List<Widget> expected = wc.list();

        List<Widget> actual = new ArrayList<>();
        actual.add(widget);
        actual.add(widget1);
        actual.add(widget2);

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