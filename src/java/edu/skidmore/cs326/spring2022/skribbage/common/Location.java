package edu.skidmore.cs326.spring2022.skribbage.common;

import java.util.Objects;

/**
 * A simple bean that represents the coordinate
 * location of a peg on the game board.
 * Currently immutable. This can change in the future
 * 
 * @author Alex Carney
 *         Code reviewed by Jonah Marcus on April 11, 2022.
 */
public class Location {
    /**
     * Row coordinate of location.
     */
    private final Integer row;

    /**
     * Column coordinate of location.
     */
    private final Integer column;

    /**
     * @param row
     *            An integer for row coordinate
     * @param column
     *            An integer for column coordinate
     */
    public Location(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    /**
     * @return The column coordinate of this location
     */
    public Integer getColumn() {
        return column;
    }

    /**
     * @return The row coordinate of this location
     */
    public Integer getRow() {
        return row;
    }

    /**
     * Two locations are only equivalent if their row and column coordinates
     * are BOTH equivalent.
     * 
     * @param o
     *            the object to compare to this location
     * @return True if the locations are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return row.equals(location.row) && column.equals(location.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
