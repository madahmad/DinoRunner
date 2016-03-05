package com.santi.anibattle.box2d;

import com.badlogic.gdx.math.Vector2;
import com.santi.anibattle.enums.UserDataType;
import com.santi.anibattle.utils.Constants;

public class PlayerUserData extends UserData {

    private final Vector2 runningPosition = new Vector2(Constants.PLAYER_X, Constants.PLAYER_Y);
    private final Vector2 dodgePosition = new Vector2(Constants.PLAYER_DODGE_X, Constants.PLAYER_DODGE_Y);

    private Vector2 jumpingLinearImpulse;
    private Vector2 rightLinearImpulse;
    private Vector2 stopVelocity;

    public PlayerUserData(float width, float height) {
        super(width, height);
        jumpingLinearImpulse = Constants.PLAYER_JUMPING_LINEAR_IMPULSE;
        rightLinearImpulse = Constants.PLAYER_RIGHT_LINEAR_IMPULSE;
        stopVelocity = Constants.PLAYER_STOP_VELOCITY;
        userDataType = UserDataType.PLAYER;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    public Vector2 getRightLinearImpulse() {
        return rightLinearImpulse;
    }

    public Vector2 getStopVelocity() {
        return stopVelocity;
    }

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
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
