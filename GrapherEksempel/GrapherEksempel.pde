Grapher grapher;

void setup() {
    size(2000, 1000);
    grapher = new Grapher(this);
}

void draw() {
    //Konverterer alle tal til doubles ved at skrive d. Husk syntax: a, b, c, d, e, f, startx, slutx
    //Alt er doubles bortset fra startx og slutx. Det kunne være, du burde ændre det
    grapher.display();
    //Den her skal være sidst, så grafen bliver tegnet ovenpå baggrunden
    grapher.renderGraph(0.5d, 1d, 2d, -2d, 4d, 0d, -0.5, 0.5);
}
