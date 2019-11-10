package wid.widget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wid.widget.entity.Widget;
import wid.widget.service.WidgetService;
import wid.widget.service.WidgetServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("widgets")
public class WidgetController {

    @Autowired
    private WidgetService widgetService;

    //Отоброжение всего листа
    @GetMapping
    public List<Widget> list() {
        return widgetService.list();
    }

    //Пагинация
    @GetMapping("/getListForPage")
    public List<Widget> pagination(HttpServletRequest request) {
        try {
            String countItems = request.getParameter("countItems");
            String page = request.getParameter("page");
            return widgetService.pagination(
                    countItems != null ? Integer.parseInt(countItems) : 10,
                    page != null ? Integer.parseInt(page) : 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
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
    @PutMapping
    public List<Widget> update(@RequestBody Widget widget) {
        return widgetService.update(widget);
    }

    //Удаление виджета
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        widgetService.delete(id);
    }
}
