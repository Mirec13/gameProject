package mirec.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import mirec.gameproject.GameProjectGame;
import mirec.scenes.Hud;

public class PlayScreen implements Screen {

    private GameProjectGame game;
    private OrthographicCamera gameCam;
    private Viewport gameViewPort;
    private Hud hud;

    public PlayScreen (GameProjectGame game) {
        this.game = game;
        gameCam = new OrthographicCamera();
        gameViewPort = new FitViewport(GameProjectGame.width, GameProjectGame.height, gameCam);
        hud = new Hud(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

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
