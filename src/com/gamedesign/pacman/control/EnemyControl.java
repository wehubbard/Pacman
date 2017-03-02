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
        updateMoveDirection();
    }

    private void updateMoveDirection()
    {
        Point2D point2D =
                gameEntity.getComponentUnsafe(PhysicsComponent.class)
                .getLinearVelocity();

        double dx = point2D.getX();
        double dy = point2D.getY();

        if(dx > 0)
            moveDirection = MoveDirection.RIGHT;
        else if(dx < 0)
            moveDirection = MoveDirection.LEFT;
        else if(dy > 0)
            moveDirection = MoveDirection.DOWN;
        else if(dy < 0)
            moveDirection = MoveDirection.UP;
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

    public void move(double dx, double dy)
    {
//        gameEntity.getPositionComponent()
//                .translate(new Point2D(dx, dy));

        gameEntity.getComponentUnsafe(PhysicsComponent.class)
                .setLinearVelocity(dx, dy);
    }
}











