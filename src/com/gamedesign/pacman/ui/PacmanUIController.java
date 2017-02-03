package com.gamedesign.pacman.ui;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.time.UpdateEvent;
import com.almasb.fxgl.time.UpdateEventListener;
import com.almasb.fxgl.ui.UIController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class PacmanUIController implements UIController, UpdateEventListener
{
    private Label title, score;

    private Canvas canvas;

    private GraphicsContext graphicsContext;

    @Override
    public void init()
    {
        title = UIFactory.newTitle("Pac-man", Color.YELLOWGREEN);
        //labelScore.setFont(FXGL.getUIFactory().newFont(24));
    }

    @Override
    public void onUpdateEvent(UpdateEvent updateEvent)
    {

    }

    public Label getLabelScore()
    {
        return score;
    }
}








