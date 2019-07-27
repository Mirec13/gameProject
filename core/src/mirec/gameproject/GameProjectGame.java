package mirec.gameproject;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import mirec.screens.PlayScreen;

public class GameProjectGame extends Game {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    //so called container which contains all render-able objects
    public SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();
        setScreen(new PlayScreen(this));
    }

    @Override
    //delegate render to Screen which are currently used
    public void render () {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}
