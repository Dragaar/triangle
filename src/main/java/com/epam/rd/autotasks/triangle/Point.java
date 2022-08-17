package com.epam.rd.autotasks.triangle;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public boolean similar(Point point)
    {
        if(point.x == this.x && point.y == this.y)
            return true;
        else return false;
    }
    public String toString() {
        return String.format("(%d;%d)", x, y);
    }


}
