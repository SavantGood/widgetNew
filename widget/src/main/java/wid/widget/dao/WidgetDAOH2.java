package wid.widget.dao;

import wid.widget.entity.Widget;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public interface WidgetDAOH2 {
    List<Widget> list() throws SQLException;
    Widget getOne(int id) throws SQLException;
    void create(Widget widget) throws SQLException;
    void update(Widget widget, int id) throws SQLException;
    void delete(int id) throws SQLException;

}
