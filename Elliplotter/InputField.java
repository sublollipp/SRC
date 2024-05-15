import processing.core.*;
import java.util.*;

public class InputField extends ClickableObject {
    int charLimit = 0;

    public InputField(PApplet p, int x, int y, int w, int h, int charLimit) {
        super(p, x, y, w, h);
        this.charLimit = charLimit;
    }

    public void keyPressed() {
        if(clicked) {
            if(t.length() < charLimit) {
                if((p.key >= '0' && p.key <= '9' || p.key == '-' && t.length() == 0)) {
                    t += p.key;
                }

                if(p.key == '.' && !t.contains(".") && (!t.contains("-") && t.length() > 0 || t.contains("-") && t.length() > 1)) {
                    t += p.key;
                }
            }
            
            if(p.key == p.BACKSPACE && t.length() > 0) {
                t = t.substring(0, t.length() - 1);
            }
        }
        
    }

    public void onRelease() {

    }

    public void otherClick() {
        clicked = false;
        c = 0;
    }

    public double getDoubleValue() {
        if(t.length() > 0 == !t.equals("-")) {
            return Double.parseDouble(t);
        } else {
            return 0d;
        } 
    }
}