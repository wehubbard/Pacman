package com.gamedesign.pacman;

import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.gamedesign.pacman.control.PlayerControl;
import com.gamedesign.pacman.type.EntityType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.gamedesign.pacman.Config.*;

public class EntityFactory
{
    public static GameEntity newPlayer(double x, double y)
    {
        return Entities.builder()
                .at(x * BLOCK_SIZE, y * BLOCK_SIZE)
                .type(EntityType.PLAYER)
                .bbox(new HitBox("BODY", BoundingShape.circle(BLOCK_SIZE / 2)))
                .viewFromNode(new Circle(BLOCK_SIZE / 2, Color.YELLOW))
                .with(new CollidableComponent(true))
                .with(new PlayerControl())
                .build();
    }
}




