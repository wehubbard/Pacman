package com.gamedesign.pacman.collision;

import com.almasb.ents.Entity;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.physics.CollisionHandler;
import com.gamedesign.pacman.PacmanApp;
import com.gamedesign.pacman.type.EntityType;

public class PlayerPelletHandler extends CollisionHandler
{
    public PlayerPelletHandler()
    {
        super(EntityType.PLAYER, EntityType.PELLET);
    }

    @Override
    protected void onCollisionBegin(Entity player, Entity pellet)
    {
        ((PacmanApp) FXGL.getApp()).onPelletPickup();
        pellet.removeFromWorld();
    }
}










