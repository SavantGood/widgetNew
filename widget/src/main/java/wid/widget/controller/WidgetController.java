package wid.widget.controller;

import org.springframework.web.bind.annotation.*;
import wid.widget.entity.Widget;
import wid.widget.exceptions.NotFoundException;

import java.util.*;

@RestController
@RequestMapping("widgets")
public class WidgetController {
    private int counter = 4;
    Widget widget = new Widget(0, 10, 10, new Date());
    Widget widget1 = new Widget(1, 15, 15, new Date());
    Widget widget2 = new Widget(2, 20, 20, new Date());


    private List<Map<String, Object>> widgetList = new ArrayList<Map<String, Object>>() {{
        add(new HashMap<String, Object>(){{put("id", "1"); put("Object", widget);}});
        add(new HashMap<String, Object>(){{put("id", "2"); put("Object", widget1);}});
        add(new HashMap<String, Object>(){{put("id", "3"); put("Object", widget2);}});
    }};


    @GetMapping
    public List<Map<String, Object>> list() {
        return widgetList;
    }

    @GetMapping("{id}")
    public Map<String, Object> getOne(@PathVariable String id) {
        return getWidget(id);
    }

    private Map<String, Object> getWidget(@PathVariable String id) {
        return widgetList.stream()
                .filter(widgetList -> widgetList.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }


    @PostMapping
    public Map<String, Object> create(@RequestBody Map<String, Object> widget) {
        widget.put("id", String.valueOf(counter++));

        widgetList.add(widget);

        return widget;
    }

    @PutMapping("{id}")
    public Map<String, Object> update(@PathVariable String id, @RequestBody Map<String, Object> widget) {
        Map<String, Object> widgetFromDB = getWidget(id);

        widgetFromDB.putAll(widget);
        widgetFromDB.put("id", id);

        return widgetFromDB;
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable String id){
        Map<String, Object> widget = getWidget(id);
        widgetList.remove(widget);
    }
}
