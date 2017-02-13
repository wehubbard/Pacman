package com.gamedesign.pacman.collision;

import com.almasb.ents.Entity;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.component.PositionComponent;
import com.almasb.fxgl.physics.CollisionHandler;
import com.gamedesign.pacman.type.EntityType;

import java.util.List;

public class PlayerPortalHandler extends CollisionHandler
{

    public PlayerPortalHandler()
    {
        super(EntityType.PLAYER, EntityType.PORTAL);
    }

    @Override
    protected void onCollisionEnd(Entity player, Entity portal)
    {
        List portals = FXGL.getApp()
                .getGameWorld()
                .getEntitiesByType(EntityType.PORTAL);

        PositionComponent positionComponent =
                player.getComponentUnsafe(PositionComponent.class);



        if(positionComponent.getX() == 0)

    }
}








