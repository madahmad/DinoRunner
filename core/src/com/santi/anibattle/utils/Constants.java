package com.santi.anibattle.utils;

import com.badlogic.gdx.math.Vector2;

public class Constants {

    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;

    public static final String DINO_ATLAS = "dino.txt";
    public static final String CRAB_ATLAS = "crab.txt";
    public static final String ROBOT_ATLAS = "robot.txt";

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10); // default: -10

    public static final String BACKGROUND_IMAGE_PATH = "bg.jpg";
    public static final String GROUND_IMAGE_PATH = "ground.png";
    public static final float WORLD_TO_SCREEN = 32;

    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 50f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    public static final float PLAYER_X = 2;
    public static final float PLAYER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float PLAYER_WIDTH = 1f;
    public static final float PLAYER_HEIGHT = 2f;
    public static float PLAYER_DENSITY = 0.5f;
    public static final float PLAYER_GRAVITY_SCALE = 3f;
    public static final float PLAYER_DODGE_X = 2f;
    public static final float PLAYER_DODGE_Y = 1.5f;
    public static final Vector2 PLAYER_STOP_VELOCITY = new Vector2(0f, 0f);
    public static final Vector2 PLAYER_JUMPING_LINEAR_IMPULSE = new Vector2(0f, 20f); // default: 0,13f
    public static final float PLAYER_HIT_ANGULAR_IMPULSE = 10f;

    public static final float ENEMY_X = 25f;
    public static final float ENEMY_DENSITY = PLAYER_DENSITY;
    public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
    public static final float RUNNING_LONG_ENEMY_Y = 2f;
    public static final float FLYING_ENEMY_Y = 3f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);

}
