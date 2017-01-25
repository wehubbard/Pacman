package com.gamedesign.pacman;

import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.EntityView;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.entity.RenderLayer;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.gamedesign.pacman.control.PlayerControl;
import com.gamedesign.pacman.type.EntityType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static com.gamedesign.pacman.Config.*;

public class EntityFactory
{
    private static RenderLayer backGround = new RenderLayer()
    {
        @Override
        public String name()
        {
            return "Background";
        }

        @Override
        public int index()
        {
            return 0;
        }
    };

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

    public static GameEntity newBlock(double x, double y)
    {
        EntityView entityView =
                new EntityView(new Rectangle(BLOCK_SIZE, BLOCK_SIZE));
        entityView.setRenderLayer(RenderLayer.BACKGROUND);

        return Entities.builder()
                .at(x * BLOCK_SIZE, y * BLOCK_SIZE)
                .type(EntityType.BLOCK)
                .viewFromNodeWithBBox(entityView)
                .build();
    }
}
















