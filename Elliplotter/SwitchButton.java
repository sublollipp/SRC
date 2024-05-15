import processing.core.*;

public class SwitchButton extends ClickableObject {
    String[] tlist;
    int currentIndex = 0;
    
    public SwitchButton(PApplet p, int x, int y, int w, int h, String[] tlist) {
        super(p, x, y, w, h);
        this.tlist = tlist;
        t = tlist[currentIndex];
    }

    public void onClick() {
        super.onClick();
        currentIndex = (currentIndex + 1) % tlist.length;
        t = tlist[currentIndex];
    }
}