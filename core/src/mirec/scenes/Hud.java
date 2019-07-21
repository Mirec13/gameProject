package mirec.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import mirec.gameproject.GameProjectGame;

public class Hud {
    public Stage stage;
    private Viewport viewPort;
    private OrthographicCamera hudCam;

    private double timeCounter;
    private int worldTime;
    private int lives;
    private int score;
    private int level;

    private Label elapsedTimeLabel;
    private Label timeLabel;
    private Label livesLabel;
    private Label remainLivesLabel;
    private Label scoreLabel;
    private Label actualScoreLabel;
    private Label levelLabel;
    private Label actualLevelLabel;

    //adding to the stage fields like level, score and so on
    public Hud (SpriteBatch batch) {
        timeCounter = 0;
        worldTime = 0;
        lives = 3;
        score = 0;
        level = 0;

        hudCam = new OrthographicCamera();
        viewPort = new FitViewport(GameProjectGame.width, GameProjectGame.height, hudCam);
        stage = new Stage(viewPort, batch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        elapsedTimeLabel = new Label(String.format("%04d", worldTime), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("LEVEL", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        actualLevelLabel = new Label(String.format("%02d", level), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        livesLabel = new Label("LIVES", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        remainLivesLabel = new Label(String.format("%02d", lives), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        actualScoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(timeLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(livesLabel).expandX();
        table.add(scoreLabel).expandX();
        table.row();
        table.add(elapsedTimeLabel).expandX();
        table.add(actualLevelLabel).expandX();
        table.add(remainLivesLabel).expandX();
        table.add(actualScoreLabel).expandX();

        stage.addActor(table);

    }

}
