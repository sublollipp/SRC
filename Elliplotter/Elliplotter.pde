Debugger debugger;
Grapher grapher;
UI ui;

void setup() {
    size(2000, 1000);
    debugger = new Debugger(this);
    debugger.toggleMouseTracking(false);
    grapher = new Grapher(this);
    ui = new UI(this);
}

void keyPressed() {
    ui.keyPressed();
}

void mousePressed() {
    ui.mousePressed();
}

void mouseReleased() {
    ui.mouseReleased();
}

int modeToNumber() {
    if( ui.getMode() == "trapez" ) { return 1; }
    if( ui.getMode() == "venstre" ) { return 0; }
    if( ui.getMode() == "højre" ) { return 2; }
    return 10;
}

void draw() {
    background(255);
    grapher.display();
    ui.display();
    ui.setEndX(grapher.renderGraph(ui.getA(), ui.getB(), ui.getC(), ui.getD(), ui.getE(), ui.getF(), ui.getXS(), ui.getXE(), modeToNumber(), ui.getSquares()));
}