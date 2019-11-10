package wid.widget.service;

import wid.widget.entity.Widget;

import java.util.List;

public interface WidgetService {
    List<Widget> list();
    Widget getOne(int id);
    List<Widget> create(Widget widget);
    List<Widget> update(Widget widget);
    void delete(int id);
    List<Widget> pagination(int countItems, int page);
}
