package me.gerryflap.draw;

import me.gerryflap.types.Position;
import me.gerryflap.types.Rekt;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

/**
 * Created by Gerryflap on 11/14/2014.
 */
public class Rectangle implements DrawObject{
    private int width;
    private int height;
    private Color color;
    private Rekt rekt;
    private Position position;
    public Rectangle(int left, int top, int right, int bottom, Color color){
        this.width = right - left;
        this.height = top-bottom;
        this.color = color;
        this.rekt = new Rekt(left, top, right, bottom);
        this.position = new Position(top, left);
    }
    public void draw(){
        GL11.glColor3b(color.getRedByte(), color.getGreenByte(), color.getBlueByte());
        // draw quad
        int left = this.getRekt().getLeft();
        int top = this.getRekt().getTop();
        int right = this.getRekt().getRight();
        int bottom = this.getRekt().getBottom();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2i(left, bottom);
        GL11.glVertex2i(right, bottom);
        GL11.glVertex2i(right, top);
        GL11.glVertex2i(left, top);
        GL11.glEnd();
    }
    public Rekt getRekt() {
        return this.rekt;
    }
    public void setPosition(int x, int y){
        this.rekt.setPosition(y, x, y + this.height, x + this.width);
        this.position.setX(x);
        this.position.setY(y);
    }
    public Position getPosition(){
        return this.position;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;
    }
}
