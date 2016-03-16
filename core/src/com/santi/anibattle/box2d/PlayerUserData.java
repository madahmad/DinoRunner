package com.santi.anibattle.box2d;

import com.badlogic.gdx.math.Vector2;
import com.santi.anibattle.enums.UserDataType;
import com.santi.anibattle.utils.Constants;

public class PlayerUserData extends UserData {

    private final Vector2 runningPosition = new Vector2(Constants.PLAYER_X, Constants.PLAYER_Y);
    private final Vector2 dodgePosition = new Vector2(Constants.PLAYER_DODGE_X, Constants.PLAYER_DODGE_Y);

    private Vector2 jumpingLinearImpulse;

    public PlayerUserData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.PLAYER;
        jumpingLinearImpulse = Constants.PLAYER_JUMPING_LINEAR_IMPULSE;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    public float getDodgeAngle() {
        return (float) (-90f * (Math.PI) / 180f);
    }

    public Vector2 getDodgePosition() {
        return dodgePosition;
    }

    public Vector2 getRunningPosition() {
        return runningPosition;
    }

    public float getHitAngularImpulse() {
        return Constants.PLAYER_HIT_ANGULAR_IMPULSE;
    }

}
