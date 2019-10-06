package wid.widget.controller;

import org.springframework.web.bind.annotation.*;
import wid.widget.entity.Widget;
import wid.widget.service.WidgetService;
import wid.widget.service.WidgetServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("widgets")
public class WidgetController {
    private WidgetService widgetService = new WidgetServiceImpl();

    //Отоброжение всего листа
    @GetMapping
    public List<Widget> list() {
        return widgetService.list();
    }

    //Пагинация
    @GetMapping("/getListForPage")
    public List<Widget> pagination(HttpServletRequest request) {
        return widgetService.pagination(request);
    }

    //Отображение одного виджета
    @GetMapping("{id}")
    public Widget getOne(@PathVariable int id) {
        return widgetService.getOne(id);
    }

    //Создание виджета
    @PostMapping
    public List<Widget> create(@RequestBody Widget widget) {
        return widgetService.create(widget);
    }

    //Редактирование виджета
    @PutMapping("{id}")
    public List<Widget> update(@PathVariable int id, @RequestBody Widget widget) {
        return widgetService.update(id, widget);
    }

    //Удаление виджета
    @DeleteMapping("{id}")
    public void delete (@PathVariable int id){
        widgetService.delete(id);
    }
}
