package ru.atom.geometry;

/**
 *  ^ Y
 *  |
 *  |
 *  |
 *  |          X
 *  .---------->
 */

public final class Geometry {
    
    private Geometry() {
    }

    /**
     * Bar is a rectangle, which borders are parallel to coordinate axis
     * Like selection bar in desktop, this bar is defined by two opposite corners
     * Bar is not oriented
     * (It is not relevant, which opposite corners you choose to define bar)
     * @return new Bar
     */
    public static Collider createBar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        Collider b = new Bar(firstCornerX, firstCornerY, secondCornerX, secondCornerY);
        return b;
    }

    /**
     * 2D point
     * @return new Point
     */
    public static Collider createPoint(int x, int y) {
        Collider p = new Point(x, y);
        return p;
    }
    
    public static boolean intersects(Bar b, Point p) {
        if (b.getSecondCornerX() < p.getX()) return false;
        if (b.getFirstCornerX() > p.getX()) return false;
        if (b.getSecondCornerY() < p.getY()) return false;
        if (b.getFirstCornerY() > p.getY()) return false;
        return true;
    }
    
    public static boolean intersects(Bar b1, Bar b2) {
        if (b1.getSecondCornerX() < b2.getFirstCornerX()) return false;
        if (b1.getFirstCornerX() > b2.getSecondCornerX()) return false;
        if (b1.getSecondCornerY() < b2.getFirstCornerY()) return false;
        if (b1.getFirstCornerY() > b2.getSecondCornerY()) return false;
        return true;
    }
}
