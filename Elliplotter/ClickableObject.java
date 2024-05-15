import processing.core.*;
import java.lang.*;

public abstract class ClickableObject {
    protected PApplet p;
    protected int x, y, w, h, c = 0, margin = 50;
    protected String t;
    protected boolean clicked = false;

    protected ClickableObject(PApplet p, int x, int y, int w, int h, String t) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.t = t;
    }

    protected ClickableObject(PApplet p, int x, int y, int w, int h) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.t = "";
    }

    public void mousePressed() {
        if(p.mouseX >= x && p.mouseX <= x + w && p.mouseY >= y && p.mouseY <= y + h) {
            onClick();
        } else {
            otherClick();
        }
    }

    public String getStringValue() {
        return t;
    }

    protected void otherClick() {

    }

    public void keyPressed() {

    }

    public void mouseReleased() {
        onRelease();
    }

    protected void onClick() {
        clicked = true;
        c = 255;
    }

    protected void onRelease() {
        clicked = false;
        c = 0;
    }

    public void override(String overrideText) {
        if(!clicked) {
            t = overrideText;
        }
    }

    public void override(float overrideText) {
        if(!clicked) {
            t = String.valueOf(overrideText);
        }
    }

    public void display() {
        p.strokeWeight(2);
        p.stroke(0);
        p.fill(255 - c);
        p.rect(x, y, w, h);
        p.fill(0 + c);
        p.textAlign(p.CENTER, p.CENTER);
        p.textSize(25);
        p.text(t, x + w / 2, y + h / 2);
    }
}