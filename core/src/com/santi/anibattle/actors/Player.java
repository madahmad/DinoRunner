package com.santi.anibattle.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.santi.anibattle.box2d.PlayerUserData;
import com.santi.anibattle.utils.Constants;

public class Player extends GameActor {

    private boolean jumping;
    private boolean dodging;
    private boolean hit;
    private Animation runningAnimation;
    private TextureRegion jumpingTexture;
    private TextureRegion dodgingTexture;
    private TextureRegion hitTexture;
    private float stateTime;

    public Player(Body body) {
        super(body);
        TextureAtlas textureAtlas = new TextureAtlas("dino.txt");
        runningAnimation = new Animation(1/79f * 3, textureAtlas.getRegions());
        stateTime = 0f;
        jumpingTexture = textureAtlas.getRegions().first();
        dodgingTexture = textureAtlas.getRegions().first();
        hitTexture = textureAtlas.getRegions().first();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.2f;
        if (dodging) {
            batch.draw(dodgingTexture, screenRectangle.x, screenRectangle.y + screenRectangle.height / 4, screenRectangle.width,
                    screenRectangle.height * 3 / 4);
        } else if (hit) {
            // When he's hit we also want to apply rotation if the body has been rotated
            batch.draw(hitTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width * 0.5f,
                    screenRectangle.height * 0.5f, screenRectangle.width, screenRectangle.height, 1f, 1f,
                    (float) Math.toDegrees(body.getAngle()));
        } else if (jumping) {
            batch.draw(jumpingTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width,
                    screenRectangle.height);
        } else {
            // Running
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw(runningAnimation.getKeyFrame(stateTime, true), screenRectangle.x, screenRectangle.y,
                    screenRectangle.getWidth(), screenRectangle.getHeight());
        }
    }

    @Override
    public PlayerUserData getUserData() {
        return (PlayerUserData) userData;
    }

    public void stopMoving() {
        body.setLinearVelocity(getUserData().getStopVelocity());
    }

    public void jump() {
        if (!(jumping || dodging || hit)) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }
    }

    public void landed() {
        jumping = false;
    }

    public void dodge() {
        if (!(jumping || hit)) {
            body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge() {
        dodging = false;
        if (!hit) {
            body.setTransform(getUserData().getRunningPosition(), 0f);
        }
    }

    public boolean isDodging() {
        return dodging;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void hit() {
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
        hit = true;
    }

    public boolean isHit() {
        return hit;
    }
}
