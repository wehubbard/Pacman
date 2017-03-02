package com.gamedesign.pacman.control;

import com.almasb.ents.Entity;

import static com.gamedesign.pacman.Config.PACMAN_TEXTURES;

public class PlayerControl extends MoveControl
{
    @Override
    public void onAdded(Entity entity)
    {
        super.onAdded(entity);
        textures = PACMAN_TEXTURES;
    }

    @Override
    public void onUpdate(Entity entity, double v)
    {
        if (bufferedDirection != null && canMove(bufferedDirection))
            gameEntity.getRotationComponent()
                    .setValue(bufferedDirection.ROTATION);

        super.onUpdate(entity, v);
    }

    @Override
    protected void updateTexture()
    {
        i = (i + 1) % textures.length;
        gameEntity.getMainViewComponent()
                .setTexture(textures[i]);
    }
}
