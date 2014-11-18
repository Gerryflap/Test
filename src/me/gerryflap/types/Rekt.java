package me.gerryflap.types;

/**
 * Created by Gerryflap on 11/14/2014.
 */
public class Rekt {
    private int top;
    private int left;
    private int right;
    private int bottom;

    public Rekt(int left, int top, int right, int bottom){
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }
    public int getTop(){
        return this.top;
    }
    public int getRight(){
        return this.right;
    }
    public int getBottom(){
        return this.bottom;
    }
    public int getLeft(){
        return this.left;
    }
    public boolean collides(Rekt rekt){
        boolean top;
        boolean bottom;
        boolean left;
        boolean right;
        top = (rekt.getTop() > this.top)&& (rekt.getTop() < this.bottom);
        bottom = (rekt.getBottom() > this.top)&& (rekt.getBottom() < this.bottom);
        left = (rekt.getLeft() > this.left)&& (rekt.getLeft() < this.right);
        right = (rekt.getRight() > this.left)&& (rekt.getRight() < this.right);
        return ((right || left)&&(top || bottom));
    }
    public void setPosition(int top, int left, int bottom, int right){
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

}
