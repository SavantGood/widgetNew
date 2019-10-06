package wid.widget.service;

import wid.widget.dao.WidgetDAO;
import wid.widget.dao.WidgetDAOImpl;
import wid.widget.entity.Widget;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class WidgetServiceImpl implements WidgetService {
    private WidgetDAO widgetDAO = new WidgetDAOImpl();

    @Override
    public List<Widget> list() {
        return widgetDAO.list();
    }

    @Override
    public Widget getOne(int id) {
        return widgetDAO.getOne(id);
    }

    @Override
    public List<Widget> create(Widget widget) {
        return widgetDAO.create(widget);
    }

    @Override
    public List<Widget> update(int id, Widget widget) {
        return widgetDAO.update(id, widget);
    }

    @Override
    public void delete(int id) {
        widgetDAO.delete(id);

    }

    @Override
    public List<Widget> pagination(HttpServletRequest request) {
        return widgetDAO.pagination(request);
    }
}
