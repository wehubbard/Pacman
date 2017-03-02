package com.gamedesign.pacman.control;

import com.almasb.ents.AbstractControl;
import com.almasb.ents.Entity;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.time.LocalTimer;
import com.gamedesign.pacman.Config;
import com.gamedesign.pacman.MoveDirection;
import com.gamedesign.pacman.component.SubTypeComponent;
import com.gamedesign.pacman.type.EnemyType;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.lang.reflect.Field;

public class EnemyControl extends MoveControl
{
    private EnemyType enemyType()
    {
        return (EnemyType) gameEntity
                .getComponentUnsafe(SubTypeComponent.class)
                .getValue();
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











