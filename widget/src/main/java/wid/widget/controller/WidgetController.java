package wid.widget.controller;

import org.springframework.web.bind.annotation.*;
import wid.widget.entity.Widget;

import java.io.IOException;
import java.util.*;
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


    //Отоброжение всего листа
    @GetMapping
    public List<Widget> list() {
        Collections.sort(widgetList, new Comparator<Widget>() {
            @Override
            public int compare(Widget o1, Widget o2) {
                if (o1.getzIndex() > o2.getzIndex()) {
                    return 1;
                } if (o1.getzIndex() < o2.getzIndex()) {
                    return -1;
                }
                return 0;
            }
        });
        return widgetList;
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
