package wid.widget.controller;

import org.springframework.web.bind.annotation.*;
import wid.widget.entity.Widget;
import wid.widget.service.WidgetServiceH2;
import wid.widget.service.WidgetServiceImplH2;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("widgetsH2")
public class WidgetControllerH2 {
    private WidgetServiceH2 widgetServiceH2 = new WidgetServiceImplH2();

    //Отоброжение всего листа
    @GetMapping
    public List<Widget> list() throws SQLException {
        return widgetServiceH2.list();
    }

    //Отображение одного виджета
    @GetMapping("{id}")
    public Widget getOne(@PathVariable int id) throws SQLException {
        return widgetServiceH2.getOne(id);
    }

    //Создание виджета
    @PostMapping
    public void create(@RequestBody Widget widget) throws SQLException {
        widgetServiceH2.create(widget);
    }

    //Редактирование виджета
    @PutMapping("{id}")
    public void update(@RequestBody Widget widget, @PathVariable int id) throws SQLException {
        widgetServiceH2.update(widget, id);
    }

    //Удаление виджета
    @DeleteMapping("{id}")
    public void delete (@PathVariable int id) throws SQLException{
        widgetServiceH2.delete(id);
    }
}
