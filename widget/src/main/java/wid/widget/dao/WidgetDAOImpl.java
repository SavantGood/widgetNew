package wid.widget.dao;

import org.springframework.web.bind.annotation.PathVariable;
import wid.widget.SortedZindex;
import wid.widget.entity.Widget;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetDAOImpl implements WidgetDAO {

    Widget widget = new Widget(1, 10, 10);
    Widget widget1 = new Widget(0, 15, 15);
    Widget widget2 = new Widget(2, 20, 20);

    private List<Widget> widgetList = new ArrayList<Widget>() {{
        add(widget);
        add(widget1);
        add(widget2);
    }};

    //Метод для генерации виджетов
    public void addElements(List<Widget> addWidgets){
        for (int i = 0; i < 500; i++) {
            int x = 10;
            int y = 10;
            int zIndex = 3;
            addWidgets.add(new Widget(zIndex + i, x + 10*i, y + 10*i));
        }
    }

    @Override
    public List<Widget> list() {

        //addElements(widgetList);
        Collections.sort(widgetList, new SortedZindex());
        return widgetList;
    }

    @Override
    public List<Widget> pagination(int countItems, int page) {
        List<Widget> widgetListPage1 = new ArrayList<>();
        int startIndex = (page - 1) * countItems;
        int endIndex = startIndex + countItems > widgetList.size() ? widgetList.size() : startIndex + countItems;
        for (int i = startIndex; i < endIndex; ++i) {
            Widget oldElement = widgetList.get(i);
            widgetListPage1.add(oldElement);
        }
        return widgetListPage1;
    }

    @Override
    public Widget getOne(int id) {
        return widgetList.stream().filter(item -> item.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Widget> create(Widget widget) {
        try {
            widgetList.add(widget);
        } catch (IndexOutOfBoundsException e) {

        }
        return widgetList;
    }

    @Override
    public List<Widget> update(Widget widget) {
        List<Widget> list = widgetList.stream().filter(item -> widget.getId() == item.getId()).collect(Collectors.toList());
        if (list.size() == 1) {
            widgetList.set(widgetList.indexOf(list.get(0)), widget);
        }
        return widgetList;
    }

    @Override
    public void delete(Widget widget) {
        widgetList.remove(widget);
    }
}
