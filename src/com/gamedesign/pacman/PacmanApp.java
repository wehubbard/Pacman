package com.gamedesign.pacman;

import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;

import static com.gamedesign.pacman.Config.*;

public class PacmanApp extends GameApplication
{
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

    }

    @Override
    protected void initAssets()
    {

    }

    @Override
    protected void initGame()
    {
        getGameWorld().addEntity(EntityFactory.newPlayer(2, 2));
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









