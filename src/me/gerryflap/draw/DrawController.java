package me.gerryflap.draw;

import me.gerryflap.types.Rekt;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerryflap on 11/14/2014.
 */
public class DrawController {
    public List<DrawObject> drawObjects;

    public DrawController(int screenWidth, int screenHeight){
        //Set up the display
        try {
            Display.setDisplayMode(new DisplayMode(screenWidth, screenHeight));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        //GL11 init
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, screenHeight, 0, screenWidth, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        this.drawObjects = new ArrayList<DrawObject>();
    }
    public void drawAll(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        for (int i = 0; i < this.drawObjects.size(); i++){
            this.drawObjects.get(i).draw();
        }
        Display.update();
    }
    public void add(DrawObject drawObject){
        System.out.println(drawObject);
        this.drawObjects.add(drawObject);
    }
    public DrawObject getDrawObject(int index){
        return this.drawObjects.get(index);
    }

    public DrawObject getColliding(Rekt rekt){
        for (int i = 0; i < this.drawObjects.size(); i++){
            if (this.drawObjects.get(i).getRekt().collides(rekt)){
                System.out.println(this.drawObjects.get(i).getPosition().getX());
                System.out.println(this.drawObjects.get(i).getPosition().getY());
                return this.drawObjects.get(i);
            }
        }
        return null;
    }


}
