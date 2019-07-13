package mirec.gameproject.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

public class GameProjectGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    Animation<TextureRegion> animation;
    private float elapsedTime = 0;

    @Override
    public void create () {
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("minipersons.txt"));
        animation = new Animation(1/15f, textureAtlas.getRegions());
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //sprite.draw(batch);
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(elapsedTime, true), 0.0f, 0.0f);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose () {
        batch.dispose();
        textureAtlas.dispose();
    }
}
