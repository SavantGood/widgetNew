package wid.widget.dao;

import wid.widget.entity.Widget;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface WidgetDAO {
    List<Widget> list();
    Widget getOne(int id);
    List<Widget> create(Widget widget);
    List<Widget> update(Widget widget);
    void delete(Widget widget);
    List<Widget> pagination(int countItems, int page);
}
