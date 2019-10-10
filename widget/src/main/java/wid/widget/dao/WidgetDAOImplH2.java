package wid.widget.dao;

import wid.widget.SortedZindex;
import wid.widget.bl.Util;
import wid.widget.entity.Widget;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;


public class WidgetDAOImplH2 extends Util implements WidgetDAOH2 {
    Connection connection = getConnection();

    @Override
    public List<Widget> list() throws SQLException {
        List<Widget> widgetList = new ArrayList<>();
        String sql = "SELECT ID, \"zIndex\", \"x\", \"y\", \"Date\" FROM WIDGETS";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Widget widget = new Widget(
                        resultSet.getInt("zIndex"),
                        resultSet.getInt("x"),
                        resultSet.getInt("y")
                );
                widget.setId(resultSet.getInt("ID"));
                widget.setDate(resultSet.getDate("Date"));

                widgetList.add(widget);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.sort(widgetList, new SortedZindex());
        return widgetList;
    }

    @Override
    public Widget getOne(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, \"zIndex\", \"x\", \"y\", \"Date\" FROM WIDGETS WHERE ID = ?";

        List<Widget> widgetOne = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                 Widget widget = new Widget(
                        resultSet.getInt("zIndex"),
                        resultSet.getInt("x"),
                        resultSet.getInt("y")
                );
                widget.setId(resultSet.getInt("ID"));
                widget.setDate(resultSet.getDate("Date"));
                widgetOne.add(widget);

                return widget;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void create(Widget widget) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO WIDGETS (\"ID\", \"zIndex\", \"x\", \"y\", \"Date\") VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, widget.getId());
            preparedStatement.setInt(2, widget.getzIndex());
            preparedStatement.setInt(3, widget.getX());
            preparedStatement.setInt(4, widget.getY());
            preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Widget widget, int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE WIDGETS SET \"zIndex\" = ?, \"x\" = ?, \"y\" = ?, \"Date\" = ? WHERE ID = ?";


        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, widget.getzIndex());
            preparedStatement.setInt(2, widget.getX());
            preparedStatement.setInt(3, widget.getY());
            preparedStatement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM WIDGETS WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
