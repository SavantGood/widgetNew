package wid.widget.service;

import wid.widget.entity.Widget;

import java.sql.SQLException;
import java.util.List;

public interface WidgetServiceH2 {
    List<Widget> list() throws SQLException;
    Widget getOne(int id) throws SQLException;
    void create(Widget widget) throws SQLException;
    void update(Widget widget, int id) throws SQLException;
    void delete(int id) throws SQLException;
}
