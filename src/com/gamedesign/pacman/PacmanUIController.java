package com.gamedesign.pacman;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.time.UpdateEvent;
import com.almasb.fxgl.time.UpdateEventListener;
import com.almasb.fxgl.ui.UIController;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static com.gamedesign.pacman.Config.*;


public class PacmanUIController implements UIController, UpdateEventListener
{
    @FXML
    private Label labelTitle, labelScore;

    @FXML
    private Canvas canvas;

    private GraphicsContext graphicsContext;

    @Override
    public void init()
    {
        labelTitle.setFont(Font.font(HEADER_FONT_SIZE));
        labelTitle.setText("Pac-man");
        labelTitle.setEffect(new DropShadow(0.5, 0.5, 1.0, Color.BLACK));
        labelTitle.setTextAlignment(TextAlignment.CENTER);

        labelScore.setFont(FXGL.getUIFactory().newFont(24));
    }

    @Override
    public void onUpdateEvent(UpdateEvent updateEvent)
    {

    }

    public Label getLabelScore()
    {
        return labelScore;
    }
}








