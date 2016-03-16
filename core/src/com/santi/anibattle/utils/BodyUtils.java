package com.santi.anibattle.utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.santi.anibattle.box2d.UserData;
import com.santi.anibattle.enums.UserDataType;

public class BodyUtils {

    public static boolean bodyIsPlayer(Body body) {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.PLAYER;
    }

    public static boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }

    public static boolean bodyIsEnemy(Body body) {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.ENEMY;
    }

    public static boolean bodyInBounds(Body body) {
        UserData userData = (UserData) body.getUserData();
        switch (userData.getUserDataType()) {
            case PLAYER:
            case ENEMY:
                return body.getPosition().x + userData.getWidth() / 2 > 0;
        }
        return true;
    }

}
