package mirec.gameproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import mirec.gameproject.GameProjectGame;

public class GameProjectLauncher {
    public static void main (String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new GameProjectGame(), config);
    }
}
