package com.gamedesign.pacman;

import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.GameEntity;
import com.almasb.fxgl.entity.RenderLayer;
import com.almasb.fxgl.gameplay.Level;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.parser.TextLevelParser;
import com.almasb.fxgl.settings.GameSettings;
import com.gamedesign.pacman.control.PlayerControl;
import com.gamedesign.pacman.type.EntityType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.gamedesign.pacman.Config.*;

public class PacmanApp extends GameApplication
{
    public GameEntity player()
    {
        return (GameEntity) getGameWorld()
                .getEntitiesByType(EntityType.PLAYER)
                .get(0);
    }

    public PlayerControl playerControl()
    {
        return player().getControlUnsafe(PlayerControl.class);
    }

    @Override
    protected void initSettings(GameSettings gameSettings)
    {
        gameSettings.setWidth(MAP_SIZE * BLOCK_SIZE + UI_SIZE);
        gameSettings.setHeight(MAP_SIZE * BLOCK_SIZE);
        gameSettings.setTitle("Pacman");
        gameSettings.setVersion("0.1");
        gameSettings.setFullScreen(false);
        gameSettings.setIntroEnabled(false);
        gameSettings.setMenuEnabled(false);
        gameSettings.setProfilingEnabled(false);    // disables FPS
        gameSettings.setApplicationMode(ApplicationMode.DEVELOPER);
    }

    @Override
    protected void initInput()
    {
//        PlayerControl playerControl =
//                player().getControlUnsafe(PlayerControl.class);

        getInput().addAction(new UserAction("Up")
        {
            @Override
            protected void onAction()
            {
                playerControl().up();
            }
        }, UP_KEY);

        getInput().addAction(new UserAction("Left")
        {
            @Override
            protected void onAction()
            {
                playerControl().left();
            }
        }, LEFT_KEY);

        getInput().addAction(new UserAction("Down")
        {
            @Override
            protected void onAction()
            {
                playerControl().down();
            }
        }, DOWN_KEY);

        getInput().addAction(new UserAction("Right")
        {
            @Override
            protected void onAction()
            {
                playerControl().right();
            }
        }, RIGHT_KEY);
    }

    @Override
    protected void initAssets()
    {

    }

    @Override
    protected void initGame()
    {
        GameEntity gameEntity =
                Entities.builder()
                        .viewFromNode(new Rectangle(getWidth(), getHeight()))
                        .buildAndAttach(getGameWorld());
        gameEntity.setRenderLayer(RenderLayer.BACKGROUND);

        TextLevelParser textLevelParser = new TextLevelParser();
        textLevelParser.addEntityProducer('P', EntityFactory::newPlayer);
        textLevelParser.addEntityProducer('B', EntityFactory::newBlock);
        textLevelParser.addEntityProducer(' ', EntityFactory::newPellet);

        Level level = textLevelParser.parse("level.txt");

        getGameWorld().setLevel(level);
    }

    @Override
    protected void initPhysics()
    {

    }

    @Override
    protected void initUI()
    {

    }

    @Override
    protected void onUpdate(double v)
    {

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}









