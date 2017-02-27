package com.gamedesign.pacman.control;

import com.almasb.ents.AbstractControl;
import com.almasb.ents.Entity;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.time.LocalTimer;
import com.gamedesign.pacman.MoveDirection;
import com.gamedesign.pacman.type.EntityType;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.gamedesign.pacman.Config.*;

public class PlayerControl extends AbstractControl
{
    private GameEntity gameEntity;
    private MoveDirection moveDirection, bufferedDirection;
    private double v;
    private LocalTimer localTimer;
    private int i;

    @Override
    public void onAdded(Entity entity)
    {
        gameEntity = (GameEntity) entity;
        localTimer = FXGL.newLocalTimer();
        localTimer.capture();
        moveDirection = MoveDirection.RIGHT;
    }

    @Override
    public void onUpdate(Entity entity, double v)
    {
        this.v = v;

        if(bufferedDirection != null && canMove(bufferedDirection))
        {
            gameEntity.getRotationComponent()
                    .setValue(bufferedDirection.ROTATION);
            moveDirection = bufferedDirection;
            bufferedDirection = null;
        }

        if(canMove(moveDirection))
            gameEntity.getPositionComponent()
                    .translate(moveDirection.DIRECTION.multiply(PACMAN_SPEED));

        if(localTimer.elapsed(Duration.millis(100)))
        {
            i = (i + 1) % PACMAN_TEXTURES.length;
            gameEntity.getMainViewComponent()
                    .setTexture(PACMAN_TEXTURES[i]);
            localTimer.capture();
        }

        String side = getSide();
        if(!side.isEmpty())
            gameEntity.setPosition(
                    getPortal(side)
                            .getPosition()
                            .add(PACMAN_OFFSET));
    }

    private String getSide()
    {
        if(gameEntity.getX() <= -BLOCK_SIZE)
            return "Left";
        else if(gameEntity.getX() >= MAP_SIZE_X * BLOCK_SIZE)
            return "Right";
        else if(gameEntity.getY() <= -BLOCK_SIZE)
            return "Top";
        else if(gameEntity.getY() >= MAP_SIZE_Y * BLOCK_SIZE)
            return "Bottom";

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
            if(portal.getX() <= BLOCK_SIZE)
                portals.put("Left", portal);
            else if(portal.getX() >= MAP_SIZE_X * BLOCK_SIZE - BLOCK_SIZE)
                portals.put("Right", portal);
            else if(portal.getY() <= BLOCK_SIZE)
                portals.put("Top", portal);
            else if(portal.getY() >= MAP_SIZE_Y * BLOCK_SIZE - BLOCK_SIZE)
                portals.put("Bottom", portal);

        switch(side)
        {
            case "Left": return portals.get("Right");
            case "Right": return portals.get("Left");
            case "Top": return portals.get("Bottom");
            case "Bottom": return portals.get("Top");
        }

        return null;
    }

    public void up()
    {
        bufferedDirection = MoveDirection.UP;
    }

    public void left()
    {
        bufferedDirection = MoveDirection.LEFT;
    }

    public void down()
    {
        bufferedDirection = MoveDirection.DOWN;
    }

    public void right()
    {
        bufferedDirection = MoveDirection.RIGHT;
    }


    private List<Entity> blocks;

    private boolean canMove(MoveDirection moveDirection)
    {
        if(blocks == null)
            blocks = FXGL.getApp().getGameWorld()
                    .getEntitiesByType(EntityType.BLOCK);

        gameEntity.getPositionComponent()
                .translate(moveDirection.DIRECTION.multiply(PACMAN_SPEED));

        boolean canMove = true;

        for(Entity block : blocks)
            if(gameEntity.getBoundingBoxComponent()
                    .isCollidingWith(Entities.getBBox(block)))
            {
                canMove = false;
                break;
            }

        gameEntity.getPositionComponent()
                .translate(moveDirection.DIRECTION.multiply(-PACMAN_SPEED));

        return canMove;
    }
}








