package com.gamedesign.pacman.control;

import com.almasb.ents.AbstractControl;
import com.almasb.ents.Entity;
import com.almasb.fxgl.entity.GameEntity;
import com.gamedesign.pacman.MoveDirection;
import com.sun.xml.internal.ws.handler.HandlerProcessor;

public class EnemyControl extends AbstractControl
{
    protected GameEntity gameEntity;
    protected String[] textures;
    protected int i;
    protected MoveDirection moveDirection;

    @Override
    public void onAdded(Entity entity)
    {
        gameEntity = (GameEntity) entity;
    }

    @Override
    public void onUpdate(Entity entity, double v)
    {
        updateTexture();
    }

    protected void updateTexture()
    {

    }
}
