package me.gerryflap.draw;
import me.gerryflap.types.Position;
import me.gerryflap.types.Rekt;
import org.lwjgl.util.Color;

/**
 * Created by Gerryflap on 11/14/2014.
 */
public interface DrawObject {
    public void draw();
    public Rekt getRekt();
    public void setPosition(int x, int y);
    public Position getPosition();
    public void setColor(Color color);
}
