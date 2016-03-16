package com.santi.anibattle.enums;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.santi.anibattle.utils.Constants;

public enum EnemyType {

    CRAB(1f, 1f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.CRAB_ATLAS),
    ROBOT(2f, 2f, Constants.ENEMY_X, Constants.RUNNING_LONG_ENEMY_Y, Constants.ENEMY_DENSITY, Constants.ROBOT_ATLAS);

    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String atlas;

    EnemyType(float width, float height, float x, float y, float density, String atlas) {
        this.density = density;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.atlas = atlas;
    }

    public float getDensity() {
        return density;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getAtlas() {
        return atlas;
    }

}
