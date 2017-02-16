package com.gamedesign.pacman;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.EntityView;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.gamedesign.pacman.type.EntityType;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static com.gamedesign.pacman.Config.*;

public class EntityFactory
{
    public static GameEntity newPlayer(double x, double y)
    {
        return Entities.builder()
                .at(new Point2D(x * BLOCK_SIZE, y * BLOCK_SIZE).add(PACMAN_OFFSET))
                .type(EntityType.PLAYER)
                .bbox(new HitBox("BODY", BoundingShape.circle(BLOCK_SIZE / 2 - 2)))
                .viewFromNode(new Circle(BLOCK_SIZE / 2 - 2, Color.YELLOW))
                .with(new CollidableComponent(true))
                .with(new PlayerControl())
                .build();
    }

    public static GameEntity newBlock(double x, double y)
    {
        EntityView entityView =
                new EntityView(new Rectangle(BLOCK_SIZE, BLOCK_SIZE, Color.NAVY));
        entityView.setRenderLayer(PLAYGROUND);

        return Entities.builder()
                .at(x * BLOCK_SIZE, y * BLOCK_SIZE)
                .type(EntityType.BLOCK)
                .viewFromNodeWithBBox(entityView)
                .build();
    }

    public static GameEntity newPellet(double x, double y)
    {
        EntityView entityView = new EntityView(new Circle(PELLET_SIZE, Color.GOLDENROD));
        entityView.setRenderLayer(PLAYGROUND);

        return Entities.builder()
                .at(x * BLOCK_SIZE + BLOCK_SIZE / 2 - PELLET_SIZE / 2,
                        y * BLOCK_SIZE + BLOCK_SIZE / 2 - PELLET_SIZE / 2)
                .type(EntityType.PELLET)
                //.bbox(new HitBox("BODY", BoundingShape.circle(PELLET_SIZE)))
                .viewFromNodeWithBBox(entityView)
                .with(new CollidableComponent(true))
                .build();
    }

    public static GameEntity newPortal(double x, double y)
    {
//        Ellipse ellipse = new Ellipse(BLOCK_SIZE / 2,
//                BLOCK_SIZE / 2,
//                BLOCK_SIZE / 4,
//                BLOCK_SIZE / 2);
//        ellipse.setFill(Color.DEEPPINK);

        //EntityView entityView = new EntityView(ellipse);
        EntityView entityView = new EntityView(new Rectangle(BLOCK_SIZE, BLOCK_SIZE));
        entityView.setRenderLayer(PLAYGROUND);

        return Entities.builder()
                .at(x * BLOCK_SIZE, y * BLOCK_SIZE)
                .type(EntityType.PORTAL)
                .viewFromNodeWithBBox(entityView)
                .with(new CollidableComponent(true))
                .build();
    }

    public static GameEntity newBackground(Color color)
    {
        double width = FXGL.getApp().getWidth();
        double height = FXGL.getApp().getHeight();

        GameEntity gameEntity =
                Entities.builder()
                        .type(EntityType.BACKGROUND)
                        .viewFromNode(new Rectangle(width, height, color))
                        .build();
        gameEntity.setRenderLayer(BACKGROUND);

        return gameEntity;
    }
}
















