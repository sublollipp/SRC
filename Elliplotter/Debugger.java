import processing.core.*;

public class Debugger {

    private boolean mouseTracking = false, alwaysMouseTrack = false;
    private PApplet p;

    public Debugger(PApplet p) {
        this.p = p;
    }

    public void toggleMouseTracking(boolean amt) {
        if(mouseTracking) { mouseTracking = false; } else { mouseTracking = true; if(amt) { alwaysMouseTrack = true; } else { alwaysMouseTrack = false; } }
    }

    public void mousePressed() {
        if(mouseTracking && !alwaysMouseTrack) {
            p.println("Mouse Coords: (" + p.mouseX + ", " + p.mouseY + ")");
        }
    }

    private void trackMouse() {
        if(alwaysMouseTrack) {
            p.println("Mouse Coords: (" + p.mouseX + ", " + p.mouseY + ")");
        }
    }

    public void run() {
        if(mouseTracking) {
            trackMouse();
        }
    }
}