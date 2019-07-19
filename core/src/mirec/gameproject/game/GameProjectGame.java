package mirec.gameproject.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import mirec.screens.PlayScreen;

public class GameProjectGame extends Game {
    public SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();
        setScreen(new PlayScreen(this));

    }

    @Override
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
