package wid.widget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import wid.widget.dao.WidgetDAOImpl;
import wid.widget.entity.Widget;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Configurable
public class WidgetServiceImpl implements WidgetService {

    @Autowired
    private WidgetDAOImpl widgetDAO;

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
        List<Widget> widgets = list().stream().filter(item -> item.getzIndex() >= widget.getzIndex()).collect(Collectors.toList());
        widgets.forEach(item -> {
            item.setzIndex(item.getzIndex() + 1);
            widgetDAO.update(item);
        });
        return widgetDAO.create(widget);
    }

    @Override
    public List<Widget> update(Widget widget) {
        return widgetDAO.update(widget);
    }

    @Override
    public void delete(int id) {
        widgetDAO.delete(widgetDAO.getOne(id));

    }

    @Override
    public List<Widget> pagination(int countItems, int page) {
        return widgetDAO.pagination(countItems, page);
    }
}
