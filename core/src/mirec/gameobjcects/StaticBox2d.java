package mirec.gameobjcects;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class StaticBox2d {

    private World world;
    private Box2DDebugRenderer b2dr = new Box2DDebugRenderer();
    private BodyDef bdef = new BodyDef();
    private PolygonShape shape = new PolygonShape();
    private FixtureDef fdef = new FixtureDef();
    private Body body;

    public StaticBox2d(World world) {
        this.world = world;
    }

    //its create predefined objects in our tile map so we should interact with them
    public void createRectangleShape(TiledMap map, int whichObj) {
        for(MapObject obj : map.getLayers().get(whichObj).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) obj).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
    }

    //renderer for created objects in our physics world, also it draws lines along the circuit so we should see whether it is created or not
    public void render(OrthographicCamera gameCam) {
        b2dr.render(world, gameCam.combined);
    }

    public Body getBody() {
        return body;
    }

    public World getWorld() {
        return world;
    }
}
