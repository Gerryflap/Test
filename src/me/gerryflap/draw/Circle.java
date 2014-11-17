package me.gerryflap.draw;

import me.gerryflap.types.Position;
import me.gerryflap.types.Rekt;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

/**
 * Created by Gerryflap on 11/14/2014.
 */
public class Circle implements DrawObject{
    private int x;
    private int y;
    private int r;
    private int quality;
    private Color color;
    private Rekt rekt;
    private Position position;
    public Circle(int x, int y, int r, int quality,  Color color){
        this.x = x;
        this.y = y;
        this.r = r;
        this.quality = quality;
        this.color = color;
        this.rekt = new Rekt(x-r, y-r, x+r, y+r);
        this.position = new Position(x, y);
    }
    public void draw(){
        GL11.glColor3b(color.getRedByte(), color.getGreenByte(), color.getBlueByte());
        // draw quad
        GL11.glBegin(GL11.GL_POLYGON);
        int x = 0;
        int y = 0;
        for (int i = 0; i < this.quality; i++) {
            x = (int) (this.x + this.r*Math.cos(( 2*Math.PI*i/((double) this.quality) ) ) );
            y = (int) (this.y + this.r*Math.sin(( 2*Math.PI*i/((double) this.quality) ) ) );
            GL11.glVertex2i(x, y);
        }
        GL11.glEnd();
    }
    public Rekt getRekt() {
        return this.rekt;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
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
