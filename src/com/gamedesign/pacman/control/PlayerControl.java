package com.gamedesign.pacman.control;

import com.almasb.ents.AbstractControl;
import com.almasb.ents.Entity;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.GameEntity;
import com.gamedesign.pacman.MoveDirection;
import com.gamedesign.pacman.type.EntityType;
import javafx.geometry.Point2D;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.gamedesign.pacman.Config.*;

public class PlayerControl extends AbstractControl
{
    private GameEntity gameEntity;
    private MoveDirection moveDirection;
    private double v;

    @Override
    public void onAdded(Entity entity)
    {
        gameEntity = (GameEntity) entity;
    }

    @Override
    public void onUpdate(Entity entity, double v)
    {
        this.v = v;

        String side = getSide();
        if(!side.isEmpty())
            gameEntity.setPosition(getPortal(side).getPosition());
    }

    private String getSide()
    {
        if(gameEntity.getX() <= -gameEntity.getWidth())
            return "Left";
        else if(gameEntity.getX() >= MAP_SIZE_X * BLOCK_SIZE)
            return "Right";

        return "";
    }

    private List<GameEntity> portals()
    {
        return FXGL.getApp()
                .getGameWorld()
                .getEntitiesByType(EntityType.PORTAL)
                .stream()
                .map(e -> (GameEntity) e)
                .collect(Collectors.toList());
    }

    private GameEntity getPortal(String side)
    {
        HashMap<String, GameEntity> portals = new HashMap<>();

        for(GameEntity portal : portals())
            if(portal.getX() <= portal.getWidth())
                portals.put("Left", portal);
            else if(portal.getX() >= MAP_SIZE_X * BLOCK_SIZE - portal.getWidth())
                portals.put("Right", portal);

        System.out.println(portals);

        switch(side)
        {
            case "Left": return portals.get("Right");
            default: return portals.get("Left");
        }
    }

    public void up()
    {
        moveDirection = MoveDirection.UP;
        //move(0, -5 * speed);
        move(0, -1 * v * PACMAN_SPEED);
        gameEntity.getRotationComponent().setValue(270);
        gameEntity.getView().setScaleX(1);
    }

    public void left()
    {
        moveDirection = MoveDirection.LEFT;
        move(-1 * v * PACMAN_SPEED, 0);
        gameEntity.getRotationComponent().setValue(0);
        gameEntity.getView().setScaleX(-1);
    }

    public void down()
    {
        moveDirection = MoveDirection.DOWN;
        move(0, 1 * v * PACMAN_SPEED);
        gameEntity.getRotationComponent().setValue(90);
        gameEntity.getView().setScaleX(1);
    }

    public void right()
    {
        moveDirection = MoveDirection.RIGHT;
        move(1 * v * PACMAN_SPEED, 0);
        gameEntity.getRotationComponent().setValue(0);
        gameEntity.getView().setScaleX(1);
    }


    private List<Entity> blocks;

    private void move(double dx, double dy)
    {
        if(!getEntity().isActive())
            return;

        if(blocks == null)
            blocks = FXGL.getApp().getGameWorld()
                    .getEntitiesByType(EntityType.BLOCK);

        double magnitude = Math.sqrt(dx * dx + dy * dy);
        long length = Math.round(magnitude);

        double x = dx / magnitude;
        double y = dy / magnitude;

        for(int i = 0; i < length; i++)
        {
            gameEntity.getPositionComponent().translate(x, y);

            boolean collision = false;

            for (Entity block : blocks)
            {
                if(Entities.getBBox(block)
                        .isCollidingWith(gameEntity.getBoundingBoxComponent()))
                {
                    collision = true;
                    break;
                }
            }

            if(collision)
            {
                gameEntity.getPositionComponent().translate(-x, -y);
                break;
            }
        }
    }
}








