package wid.widget.controller;

import org.junit.Assert;
import org.junit.Test;
import wid.widget.dao.WidgetDAOImpl;
import wid.widget.entity.Widget;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WidgetControllerTest {
    WidgetController wc = new WidgetController();
    WidgetDAOImpl wd = new WidgetDAOImpl();

    @Test
    public void create() {
        Widget widget = new Widget(0, 1, 1);

        List<Widget> createWidget = wc.create(widget);
        List<Widget> myWidget = new ArrayList<>();
        myWidget.add(widget);

        Assert.assertEquals(createWidget.get(3), myWidget.get(0));
    }

    //Метод для создания чисел
    private int numbers() {
        int number = 0;
        for (int i = 0; i < 500; ++i) {
             number = i;
        }
        return number;
    }

    @Test
    public void list() {
        List<Widget> widgetList = wc.list();
        if (widgetList.size() > 500) {
            return;
        } else  {
            wd.addElements(widgetList);
        }

        assertThat(widgetList).extracting("zIndex").contains(numbers()).doesNotHaveDuplicates();
        assertThat(widgetList).extracting("id").contains(numbers()).doesNotHaveDuplicates();
    }

}