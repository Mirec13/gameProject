package mirec.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import mirec.gameobjcects.StaticBox2d;
import mirec.gameproject.GameProjectGame;
import mirec.scenes.Hud;

public class PlayScreen implements Screen {
    private GameProjectGame game;
    private OrthographicCamera gameCam;
    private Viewport gameViewPort;

    private Hud hud;//heads up display

    //variables for tilemap loading and rendering
    private TmxMapLoader loadLevel;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //there are box2d bodies which can interact whit each other
    private World world = new World(new Vector2(0,0), true);

    //class for creating static objects predefined in tiled map
    private StaticBox2d staticBox = new StaticBox2d(world);

    //new game
    public PlayScreen (GameProjectGame game) {
        this.game = game;

        //set or main cam and screen adaptation via ViewPort
        gameCam = new OrthographicCamera();
        gameViewPort = new FitViewport(GameProjectGame.WIDTH, GameProjectGame.HEIGHT, gameCam);

        //create hud for score, lives and so on
        hud = new Hud(game.batch);

        //load our tilemap
        loadLevel = new TmxMapLoader();
        map = loadLevel.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        //initialize where should look the camera
        gameCam.position.set(gameViewPort.getWorldWidth() / 2, gameViewPort.getWorldHeight() / 2, 0);


        //adding all tile map objects into box2d world
        for (int i = 0; i < 7; i++) {
            staticBox.createRectangleShape(map, i + 2);
        }

    }

    //load new level or resume where you started
    public PlayScreen (GameProjectGame game, String level) {
        this.game = game;
        gameCam = new OrthographicCamera();
        gameViewPort = new FitViewport(GameProjectGame.WIDTH, GameProjectGame.HEIGHT, gameCam);
        hud = new Hud(game.batch);

        //TO DO
    }

    @Override
    public void show() {
    }


    public void handleInput(float delta) {
        if (Gdx.input.isTouched()) {
            gameCam.position.x += 200 * delta;
            //System.out.println(delta);
        }
    }

    public void update(float delta) {
        handleInput(delta);

        gameCam.update();
        renderer.setView(gameCam);
    }

    @Override
    public void render(float delta) {
        //update if there are any changes by delta time
        update(delta);

        //clear the screen with black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //define how it needs to be treated, there we define matrix as combined
        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

        //render our game map
        renderer.render();

        //render our box2dDebugLines
        staticBox.render(gameCam);

        game.batch.begin();
        game.batch.end();

        //draw our heads up display with predefined information
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gameViewPort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
