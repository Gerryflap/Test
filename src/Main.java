import me.gerryflap.draw.Circle;
import me.gerryflap.draw.DrawController;
import me.gerryflap.draw.DrawObject;
import me.gerryflap.draw.Rectangle;
import me.gerryflap.types.Rekt;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Gerryflap on 11/5/2014.
 */

public class Main {
    public static void main(String[] param) {
        //Init x and y
        int x;
        int y;
        //Make the DrawController
        DrawController drawController = new DrawController(800, 800);
        ArrayList<DrawObject> drawObjects = new ArrayList<DrawObject>();
        for (int i = 0; i < 100; i++) {
            drawObjects.add(new Circle((i * 100) % 900 +50, (i / 10) * 100 +50, 50, 50, new Color(0, i, 0)));
            drawController.add(drawObjects.get(i));
        }
        Rekt mouseRekt;
        DrawObject colliding;
        while (!Display.isCloseRequested()) {
            mouseRekt = new Rekt(Mouse.getX(), Mouse.getY(), Mouse.getX()+1, Mouse.getY()+1);
            colliding = drawController.getColliding(mouseRekt);
            for (int i = 0; i < drawController.drawObjects.size(); i++) {
                if (drawController.getDrawObject(i) == colliding) {
                    drawController.getDrawObject(i).setColor(new Color((byte) (Math.random() * 50), (byte) (Math.random() * 127), (byte) (Math.random() * 0)));
                }
            }
            drawController.drawAll();
            Display.sync(60);
        }
    Display.destroy();
    }
}
