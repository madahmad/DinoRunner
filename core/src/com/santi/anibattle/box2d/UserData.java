package com.santi.anibattle.box2d;

import com.badlogic.gdx.math.Vector2;
import com.santi.anibattle.enums.UserDataType;

public abstract class UserData {

    protected UserDataType userDataType;
    protected float width;
    protected float height;

    public UserData() {
    }

    public UserData(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

}
