package mirec.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import mirec.gameproject.GameProjectGame;
import mirec.scenes.Hud;

public class PlayScreen implements Screen {

    private GameProjectGame game;
    private OrthographicCamera gameCam;
    private Viewport gameViewPort;
    private Hud hud;//heads up display
    private TmxMapLoader loadLevel;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    //new game
    public PlayScreen (GameProjectGame game) {
        this.game = game;
        gameCam = new OrthographicCamera();
        gameViewPort = new FitViewport(GameProjectGame.WIDTH, GameProjectGame.HEIGHT, gameCam);
        hud = new Hud(game.batch);

        loadLevel = new TmxMapLoader();
        map = loadLevel.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gameCam.position.set(gameViewPort.getWorldWidth() / 2, gameViewPort.getWorldHeight() / 2, 0);
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
            System.out.println(delta);
        }
    }

    public void update(float delta) {
        handleInput(delta);

        gameCam.update();
        renderer.setView(gameCam);
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

        renderer.render();

        game.batch.begin();
        game.batch.end();

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
