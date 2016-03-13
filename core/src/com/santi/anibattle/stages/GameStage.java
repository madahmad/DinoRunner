package com.santi.anibattle.stages;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.santi.anibattle.actors.Background;
import com.santi.anibattle.actors.Enemy;
import com.santi.anibattle.actors.Ground;
import com.santi.anibattle.actors.Player;
import com.santi.anibattle.actors.ScoreActor;
import com.santi.anibattle.enums.EnemyType;
import com.santi.anibattle.screens.MainMenuScreen;
import com.santi.anibattle.utils.*;

public class GameStage extends Stage implements ContactListener, InputProcessor {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    private World world;
    private Ground ground;
    private Player player;
    private Game game;
    private Score score;

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;

    private Rectangle moveLeftControl;
    private Rectangle moveRightControl;
    private Rectangle moveUpControl;
    private Rectangle moveDownControl;

    private Vector3 touchPoint;

    public GameStage(Game game) {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        this.game = game;
        setUpWorld();
        setUpCamera();
        setUpTouchControlAreas();
    }

    private void setUpWorld() {
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setUpBackground();
        setUpGround();
        setUpRunner();
        createEnemy();
        setUpScore();
    }

    private void setUpCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    private void setUpTouchControlAreas() {
        touchPoint = new Vector3();
        moveLeftControl = new Rectangle(0, 0,
                getCamera().viewportWidth / 3, getCamera().viewportHeight);
        moveRightControl = new Rectangle(getCamera().viewportWidth * (float) 2 / 3, 0,
                getCamera().viewportWidth / 3, getCamera().viewportHeight);
        moveUpControl = new Rectangle(getCamera().viewportWidth / 3, getCamera().viewportHeight / 2,
                getCamera().viewportWidth / 3, getCamera().viewportHeight / 2);
        moveDownControl = new Rectangle(getCamera().viewportWidth / 3, 0,
                getCamera().viewportWidth / 3, getCamera().viewportHeight / 2);
        Gdx.input.setInputProcessor(this);
    }

    private void setUpBackground() {
        addActor(new Background());
    }

    private void setUpGround() {
        ground = new Ground(WorldUtils.createGround(world));
        addActor(ground);
    }

    private void setUpRunner() {
        player = new Player(WorldUtils.createRunner(world));
        addActor(player);
    }

    private void setUpScore() {
        score = new Score("0");
        addActor(new ScoreActor(score));
    }

    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsPlayer(a) && BodyUtils.bodyIsEnemy(b)) ||
                (BodyUtils.bodyIsEnemy(a) && BodyUtils.bodyIsPlayer(b))) {
            player.hit();
            float delay = 3; // seconds

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    game.setScreen(new MainMenuScreen(game));
                }
            }, delay);

        } else if ((BodyUtils.bodyIsPlayer(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsPlayer(b))) {
            player.landed();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            update(body);
        }

        accumulator += delta;

        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

        //TODO: Implement interpolation
    }

    private void update(Body body) {
        if (!BodyUtils.bodyInBounds(body)) {
            if (BodyUtils.bodyIsEnemy(body) && !player.isHit()) {
                createEnemy();
                score.incrementScore();
            }
            world.destroyBody(body);
        }
    }

    private void createEnemy() {
        EnemyType enemyType = RandomUtils.getRandomEnemyType();
        Enemy enemy = new Enemy(WorldUtils.createEnemy(world, enemyType), enemyType);
        addActor(enemy);
    }

    // ----- Controls -----

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        translateScreenToWorldCoordinates(x, y);
        Gdx.app.log("Touched", "x:" + x + ", y:" + y);
        if (leftControlTouched(touchPoint.x, touchPoint.y)) {
            //
        } else if (rightControlTouched(touchPoint.x, touchPoint.y)) {
            // player.moveRight();
        } else if (upControlTouched(touchPoint.x, touchPoint.y)) {
            player.jump();
        } else if (downControlTouched(touchPoint.x, touchPoint.y)) {
            player.dodge();
        }
        return super.touchDown(x, y, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (player.isDodging()) {
            player.stopDodge();
        }
        if (!player.isJumping()) {
            player.stopMoving();
        }
        return super.touchUp(screenX, screenY, pointer, button);
    }

    private boolean rightControlTouched(float x, float y) {
        return moveRightControl.contains(x, y);
    }

    private boolean leftControlTouched(float x, float y) {
        return moveLeftControl.contains(x, y);
    }

    private boolean upControlTouched(float x, float y) {
        return moveUpControl.contains(x, y);
    }

    private boolean downControlTouched(float x, float y) {
        return moveDownControl.contains(x, y);
    }

    private void translateScreenToWorldCoordinates(int x, int y) {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }

    // ----- Desktop Controls -----

    @Override
    public boolean keyDown(int keyCode) {
        switch (keyCode) {
            case Input.Keys.UP:
                player.jump();
            case Input.Keys.DOWN:
                player.dodge();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keyCode) {
        if (keyCode == Input.Keys.DOWN) {
            player.stopDodge();
        }
        return true;
    }
}
