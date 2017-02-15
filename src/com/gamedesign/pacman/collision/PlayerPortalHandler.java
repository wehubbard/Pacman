package com.gamedesign.pacman.collision;

import com.almasb.ents.Entity;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.entity.component.PositionComponent;
import com.almasb.fxgl.physics.CollisionHandler;
import com.gamedesign.pacman.type.EntityType;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerPortalHandler extends CollisionHandler
{

    public PlayerPortalHandler()
    {
        super(EntityType.PLAYER, EntityType.PORTAL);
    }

    @Override
    protected void onCollisionEnd(Entity player, Entity portal)
    {
        List<GameEntity> portals = FXGL.getApp()
                .getGameWorld()
                .getEntitiesByType(EntityType.PORTAL)
                .stream()
                .map(e -> (GameEntity) e)
                .collect(Collectors.toList());

        HashMap<String, GameEntity> portalMap = new HashMap();
        for(GameEntity e : portals)
        {
            if(e.getPositionComponent().getX() == 0)
                portalMap.put("Left", e);

        }

        //if(positionComponent.getX() <= 0)
    }
}








