package com.gamedesign.pacman.control;

import com.almasb.ents.AbstractControl;
import com.almasb.ents.Entity;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.time.LocalTimer;
import com.gamedesign.pacman.Config;
import com.gamedesign.pacman.MoveDirection;
import com.gamedesign.pacman.component.SubTypeComponent;
import com.gamedesign.pacman.type.EnemyType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.lang.reflect.Field;

public class EnemyControl extends AbstractControl
{
    protected GameEntity gameEntity;
    protected String[] textures;
    protected int i;
    protected MoveDirection moveDirection;
    private LocalTimer localTimer;

    private EnemyType enemyType()
    {
        return (EnemyType) gameEntity
                .getComponentUnsafe(SubTypeComponent.class)
                .getValue();
    }

    @Override
    public void onAdded(Entity entity)
    {
        gameEntity = (GameEntity) entity;
        moveDirection = MoveDirection.RIGHT;
        localTimer = FXGL.newLocalTimer();
        localTimer.capture();
    }

    @Override
    public void onUpdate(Entity entity, double v)
    {
        if(localTimer.elapsed(Duration.millis(250)))
        {
            updateTexture();
            localTimer.capture();
        }
    }

    protected void updateTexture()
    {
        String str = enemyType() + "_" + moveDirection + "_TEXTURES";
        System.out.println(str);
        try {
            Field field = Config.class.getField(str);
            textures = (String[]) field.get(new Config());
        }
        catch (Exception e) {}

        ImageView imageView =
                new ImageView(new Image("assets/textures/" + textures[i]));

        gameEntity.getMainViewComponent()
                .setView(imageView);

        i = (i + 1) % textures.length;
    }
}











