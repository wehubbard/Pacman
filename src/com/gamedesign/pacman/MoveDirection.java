package com.gamedesign.pacman;

import javafx.geometry.Point2D;

public enum MoveDirection
{
    UP(new Point2D(0, -1), 270),
    LEFT(new Point2D(-1, 0), 180),
    DOWN(new Point2D(0, 1), 90),
    RIGHT(new Point2D(1, 0), 0);

    public final Point2D DIRECTION;
    public final int ROTATION;

    MoveDirection(Point2D point2D, int rotation)
    {
        DIRECTION = point2D;
        ROTATION = rotation;
    }

    MoveDirection next()
    {
        return values()[(ordinal() + 1) % values().length];
    }

    MoveDirection previous()
    {
        return values()[(ordinal() - 1) % values().length];
    }
}














