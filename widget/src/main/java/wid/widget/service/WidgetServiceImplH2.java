package wid.widget.service;

import wid.widget.SortedZindex;
import wid.widget.dao.WidgetDAOH2;
import wid.widget.dao.WidgetDAOImplH2;
import wid.widget.entity.Widget;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetServiceImplH2 implements WidgetServiceH2 {
    private WidgetDAOH2 widgetDAOImplH2 = new WidgetDAOImplH2();

    @Override
    public List<Widget> list() throws SQLException {
        return widgetDAOImplH2.list();
    }

    @Override
    public Widget getOne(int id) throws SQLException {
        return widgetDAOImplH2.getOne(id);
    }

    @Override
    public void create(Widget widget) throws SQLException {
        List<Widget> widgets = list().stream().filter(item -> item.getzIndex() >= widget.getzIndex()).collect(Collectors.toList());
        widgetDAOImplH2.create(widget);
        widgets.forEach(item -> {
            item.setzIndex(item.getzIndex() + 1);
            try {
                update(item, item.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void update(Widget widget, int id) throws SQLException {
        widgetDAOImplH2.update(widget, id);

    }

    @Override
    public void delete(int id) throws SQLException {
        widgetDAOImplH2.delete(id);
    }
}
