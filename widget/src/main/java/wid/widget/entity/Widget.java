package wid.widget.entity;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Widget {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;

    private int zIndex;

    private int x;

    private int y;

    private Date date;

    public Widget(int zIndex, int x, int y) {
        this.zIndex = zIndex;
        this.x = x;
        this.y = y;
        this.date = new Date();
        this.id = count.incrementAndGet();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
