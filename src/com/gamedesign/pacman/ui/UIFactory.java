package com.gamedesign.pacman.ui;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import static com.gamedesign.pacman.Config.HEADER_FONT_SIZE;

public class UIFactory
{
    public static Label newTitle(String text, Color color)
    {
        Label label = new Label();
        label.setTranslateX(0);
        label.setTranslateY(0);
        label.setTextFill(color);
        label.setFont(Font.font(HEADER_FONT_SIZE));
        label.setText(text);
        label.setEffect(new DropShadow(0.5, 0.5, 1.0, Color.BLACK));
        label.setTextAlignment(TextAlignment.CENTER);

        return label;
    }
}
