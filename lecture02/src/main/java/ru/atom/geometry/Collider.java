package ru.atom.geometry;

/**
 * Entity that can physically intersect, like flame and player
 */
public interface Collider {
    boolean equals(Object o);
    boolean isColliding(Collider other);
}