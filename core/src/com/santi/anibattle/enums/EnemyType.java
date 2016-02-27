package com.santi.anibattle.enums;

import com.santi.anibattle.utils.Constants;

public enum EnemyType {

    /*
    RUNNING_SMALL(1f, 1f, Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y, Constants.ENEMY_DENSITY,
            Constants.RUNNING_SMALL_ENEMY_REGION_NAMES),
    RUNNING_WIDE(2f, 1f, Constants.ENEMY_X, Constants.RUNNING_SHORT_ENEMY_Y, Constants.ENEMY_DENSITY,
            Constants.RUNNING_WIDE_ENEMY_REGION_NAMES),
    RUNNING_LONG(1f, 2f, Constants.ENEMY_X, Constants.RUNNING_LONG_ENEMY_Y, Constants.ENEMY_DENSITY,
            Constants.RUNNING_LONG_ENEMY_REGION_NAMES),
    RUNNING_BIG(2f, 2f, Constants.ENEMY_X, Constants.RUNNING_LONG_ENEMY_Y, Constants.ENEMY_DENSITY,
            Constants.RUNNING_BIG_ENEMY_REGION_NAMES),
    FLYING_SMALL(1f, 1f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY,
            Constants.FLYING_SMALL_ENEMY_REGION_NAMES),
    FLYING_WIDE(2f, 1f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY,
            Constants.FLYING_WIDE_ENEMY_REGION_NAMES),*/
    DOLPHIN(1f, 1f, Constants.ENEMY_X, Constants.FLYING_ENEMY_Y, Constants.ENEMY_DENSITY,
            Constants.DOLPHIN_ENEMY_REGION_NAMES);

    private float width;
    private float height;
    private float x;
    private float y;
    private float density;
    private String[] regions;

    EnemyType(float width, float height, float x, float y, float density, String[] regions) {
        this.density = density;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.regions=regions;
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

    public String[] getRegions(){
        return regions;
    }

}
