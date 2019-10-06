package wid.widget.controller;

import org.springframework.web.bind.annotation.*;
import wid.widget.SortedZindex;
import wid.widget.entity.Widget;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("widgets")
public class WidgetController {
    Widget widget = new Widget(1, 10, 10);
    Widget widget1 = new Widget(0, 15, 15);
    Widget widget2 = new Widget(2, 20, 20);

    private List<Widget> widgetList = new ArrayList<Widget>() {{
        add(widget);
        add(widget1);
        add(widget2);
    }};

    private void addElements(){
        for (int i = 0; i < 500; i++) {
            int x = 10;
            int y = 10;
            int zIndex = 1;
            widgetList.add(new Widget(zIndex + i, x + 10*i, y + 10*i));
        }
    }


    //Отоброжение всего листа
    @GetMapping
    public List<Widget> list() {
        addElements();
        Collections.sort(widgetList, new SortedZindex());
        return widgetList;
    }

    //Пагинация
    @GetMapping("/getListForPage")
    public List<Widget> pagination(HttpServletRequest request) {
        try {
            if (request.getParameter("countItems") == null){
                return forPagination(10, 1);
            } if (request.getParameter("countItems") != null) {
                int countItems = Integer.parseInt(request.getParameter("countItems"));
                int page = Integer.parseInt(request.getParameter("page"));
                return forPagination(countItems, page);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return forPagination(10, 1);
        }
        return forPagination(10, 1);
    }

    private List<Widget> forPagination(int countItems, int page) {
        List<Widget> widgetListPage1 = new ArrayList<>();
        int startIndex = (page - 1) * countItems;
        int endIndex = startIndex + countItems > widgetList.size() ? widgetList.size() : startIndex + countItems;
        for (int i = startIndex; i < endIndex; ++i) {
            Widget oldElement = widgetList.get(i);
            widgetListPage1.add(oldElement);
        }
        return widgetListPage1;
    }


    //Отображение одного виджета
    @GetMapping("{id}")
    public Widget getOne(@PathVariable int id) {
        return getWidget(id);
    }

    //Поиск по коллекции
    private Widget getWidget(@PathVariable int id) {
        return widgetList.stream().filter(item -> item.getId() == id).collect(Collectors.toList()).get(0);
    }

    //Создание виджета
    @PostMapping
    public List<Widget> create(@RequestBody Widget widget) throws IOException {
        try {
                for (int i = 0; widgetList.size() > i; ++i) {
                Widget oldValue = widgetList.get(i);
                if (widget.getzIndex() <= oldValue.getzIndex()) {
                    int newValue = oldValue.getzIndex() + 1;
                    Widget widgetForSet = new Widget(newValue, oldValue.getX(), oldValue.getY());
                    widgetList.set(i, widgetForSet);
                }
            }
            widgetList.add(widget);
        } catch (IndexOutOfBoundsException e) {
            widgetList.add(widget);
        }
        return widgetList;
    }

    //Редактирование виджета
    @PutMapping("{id}")
    public List<Widget> update(@PathVariable int id, @RequestBody Widget widget) {
        Widget createWidget = getWidget(id);
        createWidget.setzIndex(widget.getzIndex());
        createWidget.setX(widget.getX());
        createWidget.setY(widget.getY());
        return widgetList;
    }

    //Удаление виджета
    @DeleteMapping("{id}")
    public void delete (@PathVariable int id){
        Widget widget = getWidget(id);
        widgetList.remove(widget);
    }

}
