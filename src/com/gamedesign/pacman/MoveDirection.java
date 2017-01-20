package com.gamedesign.pacman;

public enum MoveDirection
{
    UP, LEFT, DOWN, RIGHT;

    MoveDirection next()
    {
        return values()[(ordinal() + 1) % values().length];
    }

    MoveDirection previous()
    {
        return values()[(ordinal() - 1) % values().length];
    }
}














