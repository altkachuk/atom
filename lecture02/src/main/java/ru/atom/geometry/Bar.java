package ru.atom.geometry;

public class Bar implements Collider {
    
    private int firstCornerX;
    private int firstCornerY;
    private int secondCornerX;
    private int secondCornerY;
    
    public Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        if (firstCornerX > secondCornerX) {
            this.firstCornerX = secondCornerX;
            this.secondCornerX = firstCornerX;
        } else {
            this.firstCornerX = firstCornerX;
            this.secondCornerX = secondCornerX;
        }
        if (firstCornerY > secondCornerY) {
            this.firstCornerY = secondCornerY;
            this.secondCornerY = firstCornerY;
        } else {
            this.firstCornerY = firstCornerY;
            this.secondCornerY = secondCornerY;
        }
    }
    
    public int getFirstCornerX() {
        return firstCornerX;
    }

    public int getFirstCornerY() {
        return firstCornerY;
    }

    public int getSecondCornerX() {
        return secondCornerX;
    }

    public int getSecondCornerY() {
        return secondCornerY;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Bar b = (Bar) o;
        
        if (firstCornerX != b.getFirstCornerX()) return false;
        if (firstCornerY != b.getFirstCornerY()) return false;
        if (secondCornerX != b.getSecondCornerX()) return false;
        if (secondCornerY != b.getSecondCornerY()) return false;
        
        return true;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (equals(other)) return true;
        if (other instanceof Point) {
            Point p = (Point) other;
            if (Geometry.intersects(this, p)) return true;
        } else if (other instanceof Bar) {
            Bar b = (Bar) other;
            if (Geometry.intersects(this, b)) return true; 
        }
        return false;
    }

}
