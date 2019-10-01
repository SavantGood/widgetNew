package wid.widget.entity;

import java.util.Date;

public class Widget {

    private int zIndex;

    private int x;

    private int y;

    private Date date;

    public Widget(int zIndex, int x, int y, Date date) {

        this.zIndex = zIndex;
        this.x = x;
        this.y = y;
        this.date = date;
    }


    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
