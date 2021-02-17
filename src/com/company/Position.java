package com.company;

import java.util.Objects;

public class Position {
    private int xCoordinate;
    private int yCoordinate;

    public Position (int xCoordinate,int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    private double countHeuristicDistance(Position one, Position two){
        final int SQUARED = 2;
        int xDiff = one.getxCoordinate ()- two.getxCoordinate ();
        int yDiff = one.getyCoordinate ()- two.getyCoordinate ();

        Double x = Math.pow ( xDiff,SQUARED );
        Double y = Math.pow ( yDiff,SQUARED );
        return Math.sqrt ( x + y );
    }

    public int getxCoordinate () {
        return xCoordinate;
    }

    public void setxCoordinate (int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate () {
        return yCoordinate;
    }

    public void setyCoordinate (int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return xCoordinate == position.xCoordinate && yCoordinate == position.yCoordinate;
    }

    @Override
    public int hashCode () {
        return Objects.hash ( xCoordinate,yCoordinate );
    }
}
