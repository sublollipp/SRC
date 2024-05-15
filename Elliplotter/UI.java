import processing.core.*;
public class UI {
    PApplet p;
    InputField inputA, inputB, inputC, inputD, inputE, inputF, inputXS, inputXE, inputFirkanter;
    SwitchButton modeButton;
    String[] modes = {"venstre", "højre", "trapez"};

    public UI(PApplet p) {
        this.p = p;
        inputA = new InputField(p, 110, 220, 400, 50, 7);
        inputB = new InputField(p, 620, 220, 400, 50, 7);
        inputC = new InputField(p, 110, 280, 400, 50, 7);
        inputD = new InputField(p, 620, 280, 400, 50, 7);
        inputE = new InputField(p, 110, 340, 400, 50, 7);
        inputF = new InputField(p, 620, 340, 400, 50, 7);
        inputXS = new InputField(p, 110, 600, 400, 50, 7);
        inputXE = new InputField(p, 620, 600, 400, 50, 7);
        modeButton = new SwitchButton(p, 110, 660, 910, 100, modes);
        inputFirkanter = new InputField(p, 110, 770, 910, 100, 3);
    }

    public void mousePressed() {
        inputA.mousePressed();
        inputB.mousePressed();
        inputC.mousePressed();
        inputD.mousePressed();
        inputE.mousePressed();
        inputF.mousePressed();
        inputXS.mousePressed();
        inputXE.mousePressed();
        modeButton.mousePressed();
        inputFirkanter.mousePressed();
    }

    public void mouseReleased() {
        inputA.mouseReleased();
        inputB.mouseReleased();
        inputC.mouseReleased();
        inputD.mouseReleased();
        inputE.mouseReleased();
        inputF.mouseReleased();
        inputXS.mousePressed();
        inputXE.mousePressed();
        modeButton.mouseReleased();
        inputFirkanter.mouseReleased();
    }

    public void keyPressed() {
        inputA.keyPressed();
        inputB.keyPressed();
        inputC.keyPressed();
        inputD.keyPressed();
        inputE.keyPressed();
        inputF.keyPressed();
        inputXS.keyPressed();
        inputXE.keyPressed();
        inputFirkanter.keyPressed();
    }

    public void display() {
        p.textAlign(p.CENTER, p.CENTER);
        p.fill(0);
        p.textSize(75);
        p.text("f(x) = ax^5+bx^4+cx^3+dx^2+ex+f", 600, 70);
        inputA.display();
        inputB.display();
        inputC.display();
        inputD.display();
        inputE.display();
        inputF.display();
        inputXS.display();
        inputXE.display();
        modeButton.display();
        inputFirkanter.display();
        p.textSize(40);
        p.fill(0);
        p.textAlign(p.RIGHT, p.CENTER);
        p.text("a:", 105, 245);
        p.text("b:", 615, 245);
        p.text("c:", 105, 305);
        p.text("d:", 615, 305);
        p.text("e:", 105, 365);
        p.text("f:", 615, 365);
    }

    public double getA() {
        return inputA.getDoubleValue();
    }

    public double getB() {
        return inputB.getDoubleValue();
    }

    public double getC() {
        return inputC.getDoubleValue();
    }

    public double getD() {
        return inputD.getDoubleValue();
    }

    public double getE() {
        return inputE.getDoubleValue();
    }

    public double getF() {
        return inputF.getDoubleValue();
    }

    public float getXS() {
        return (float)inputXS.getDoubleValue();
    }

    public float getXE() {
        return (float)inputXE.getDoubleValue();
    }

    public String getMode() {
        return modeButton.getStringValue();
    }

    public int getSquares() {
        int n = (int)inputFirkanter.getDoubleValue();
        if(n < 1) { n = 1; }
        if( n > 800 ) { n = 800; }
        inputFirkanter.override(n);
        return n;
    }

    public void setEndX(float value) {
        inputXE.override(value);
    }
}