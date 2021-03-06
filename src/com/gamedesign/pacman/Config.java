package com.gamedesign.pacman;

import com.almasb.fxgl.entity.RenderLayer;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class Config
{
    public static final KeyCode UP_KEY = KeyCode.W;
    public static final KeyCode LEFT_KEY = KeyCode.A;
    public static final KeyCode DOWN_KEY = KeyCode.S;
    public static final KeyCode RIGHT_KEY = KeyCode.D;

    public static final int BLOCK_SIZE = 40;
    public static final int MAP_SIZE_X = 19;
    public static final int MAP_SIZE_Y = 21;
    public static final int UI_SIZE = 200;
    public static final int PELLET_SIZE = BLOCK_SIZE / 8;

    public static final int TITLE_FONT_SIZE = 48;
    public static final int BODY_FONT_SIZE = 24;

    public static final int PACMAN_SPEED = 3;
    public static final Point2D PACMAN_OFFSET = new Point2D(1, 1);
    public static final String[] PACMAN_TEXTURES = {"pacman00.png", "pacman01.png", "pacman02.png"};

    public static final String[] BLINKY_RIGHT_TEXTURES = {"blinkyRight00.png", "blinkyRight01.png"};
    public static final String[] BLINKY_LEFT_TEXTURES = {"blinkyLeft00.png", "blinkyLeft01.png"};
    public static final String[] BLINKY_UP_TEXTURES = {"blinkyTop00.png", "blinkyTop01.png"};
    public static final String[] BLINKY_DOWN_TEXTURES = {"blinkyBottom00.png", "blinkyBottom01.png"};

    public static final RenderLayer BACKGROUND = new RenderLayer()
    {
        @Override
        public String name() { return "BACKGROUND"; }

        @Override
        public int index() { return 0; }
    };

    public static final RenderLayer PLAYGROUND = new RenderLayer()
    {
        @Override
        public String name() { return "PLAYGROUND"; }

        @Override
        public int index() { return Integer.MAX_VALUE / 2; }
    };

    public static final RenderLayer FOREGROUND = new RenderLayer()
    {
        @Override
        public String name() { return "FOREGROUND"; }

        @Override
        public int index() { return Integer.MAX_VALUE;}
    };
}










