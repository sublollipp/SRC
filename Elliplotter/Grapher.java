/*
 * I denne fil bruges ordene reel og matematisk rigtig meget. Når noget ses som matematisk, ses det, som det, grafen afbilder.
 * Altså, en matematisk ændring med 1 på x-aksen svarer til at øge den uafhængige variabel i funktionen med 1. Grafen kommer
 * altid reelt set til at være 800*800 pixels, men dens matematiske start- og slutpunkter ændrer sig, afhængig af, hvad man sætter.
 * Da den matematiske afstand mellem venstre og højre side af grafen kan være alt fra 0.1 til 1000000 (og det samme med øverst og nederst),
 * er xmult og ymult brugt til at beskrive, hvor mange pixels der er hen over en matematisk ændring af x på 1.
 * 
 * FOR EKSEMPEL:
 * Hvis den matematiske bredde / definitionsmængden af en graf er lig 800 (altså det sammme som den reele bredde), er xmult bare 1, 
 * da der er 1 pixel for hver 1, man går hen på x-værdien.
 * 
 * Hvis den matematiske bredde derimod er mindre end den reele (hvis man f.eks. prøver at afbilde en graf mellem x = -4 og x = 4), 
 * går der mange pixels pr. 1 ændring af x. I dette specifikke tilfælde ville xmult være 100, da den matematiske bredde af grafen
 * er 100 gange mindre end den reele, og der dermes går 100 pixels vandret på 1 ændring af x.
 * 
 * BTW i java omdannes typer anderledes end man normalt ville gøre i processing. Hvis jeg vil have float værdien af 17+3, så er det:
 * (float)(17+3)
 * Det er meget mystisk, men man vænner sig til det i guess
 * 
 * Føl dig ikke skyldig, hvis du skal læse koden igennem 10-15 gange for at forstå det. Det kommer jeg også til at skulle gøre i morgen :(
 * 
 * 13/06/2024 | 02:12 AM
 */

import processing.core.*;
import java.lang.Math;

public class Grapher {
    private int x = 1175, y = 25, w = 800, h = 800;
    //xmult er hvor mange pixels der er på 1 ændring i x-aksen matematisk. Samme med y.
    //Start og slut er de matematiske start- og slutpunkter af grafen
    private float xmult = 1, ymult = 1, startx = -400, endx = 400, starty = -400, endy = 400, sum = 0, integral = 0;

    PApplet p;

    //capx og capy gør, så linjerne ikke går ud over grafen
    private float capx(float xin) {
        float returnValue = xin;
        
        if(xin < startx) { returnValue = startx; }
        if(xin > endx) { returnValue = endx; }
        
        return returnValue;
    }

    private float capy(float yin) {
        float returnValue = yin;
        
        if(yin < starty) { returnValue = starty; }
        if(yin > endy) { returnValue = endy; }
        
        return returnValue;
    }

    //Tager de matematiske koordinater af to punkter på en linje og tegner dem på grafen.
    //Her omvendes y blandt andet (da y går opad i et traditionelt koordinatsystem, men nedad i programmering)
    private void line(float x1, float y1, float x2, float y2, int sw) {
        p.strokeWeight(sw);
        p.line(xToPixels(x1), yToPixels(y1), xToPixels(x2), yToPixels(y2));
    }

    private int xToPixels(float input) {
        return (int)((capx(input) - startx) * xmult + x);
    }

    private int yToPixels(float input) {
        return (int)(y + h - (capy(input) - starty) * ymult);
    }

    private float xToMath(int input) {
        return (float)(input / xmult + startx);
    }

    private float yToMath(int input) {
        return (float)(input / ymult + starty);
    }

    private int gX(int input) {
        return input + x;
    }

    private int gY(int input) {
        return y + h - input;
    }

    public Grapher(PApplet p) {
        this.p = p;
    }

    //Tegner de to akser
    private void drawAxes() {
        p.stroke(128);
        line(startx, 0, endx, 0, 2);
        line(0, starty, 0, endy, 2);
    }

    public void renderInt(int mode, int amount, double a, double b, double c, double d, double e, double f) {
        sum = 0;
        int stepSize = (int)(w / amount);
        p.fill(136, 219, 204);
        p.beginShape(p.QUADS);
        int leftx, rightx;
        for(int i = 0; i < w - 1; i += stepSize) {
            float currentlefty = 0, currentrighty = 0;
            p.vertex(gX(i + stepSize), yToPixels(0));
            p.vertex(gX(i), yToPixels(0));

            if( mode == 2 ) { leftx = 1; } else { leftx = 0; }
            if( mode == 0 ) { rightx = 0; } else { rightx = 1; }

            currentlefty = Calc.polyn(xToMath(i + stepSize * leftx), a, b, c, d, e, f);
            currentrighty = Calc.polyn(xToMath(i + stepSize * rightx), a, b, c, d, e, f);

            p.vertex(gX(i), yToPixels(currentlefty));
            p.vertex(gX(i + stepSize), yToPixels(currentrighty));

            if(currentlefty == currentrighty) {
                sum += (stepSize / xmult) * Math.abs(currentlefty);
                /*Debug statements
                p.println(String.valueOf(sum) + " som resultat af bredden " + String.valueOf((stepSize / xmult)) + " og højden " + String.valueOf(currentlefty));
                p.println("xmult: " + String.valueOf(xmult) + " | " + "Pixelbredde: " + String.valueOf(stepSize / xmult));
                */
            } else {
                sum += (stepSize / xmult) * (currentlefty + 0.5 * (currentrighty - currentlefty));
            }
        }
        p.endShape();
    }

    private void drawLabels() {
        p.fill(0);
        p.textSize(15);
        p.textAlign(p.RIGHT, p.CENTER);
        p.text("y = " + starty, xToPixels(capx(0)), gY(-15));
        p.text("y = " + endy, xToPixels(capx(0)), gY(815));
        p.textSize(30);
        p.textAlign(p.CENTER, p.CENTER);
        p.text("Sum: " + String.valueOf(sum), x + w / 2, y + h + 40);
        p.text("Bestemt integral: " + String.valueOf(integral), x + w / 2, y + h + 80);
        p.text("Afvigelse: " + String.valueOf(Math.abs(sum - integral) * 100 / integral) + "%", x + w / 2, y + h + 120);
    }

    //Tegner grafen udfra funktionens konstanter samt x-rækkevidden. Denne køres i draw()
    public float renderGraph(double a, double b, double c, double d, double e, double f, float xstart, float xend, int intMode, int intAmount) {
        //opdaterer hele classens startx og endx værdier
        startx = xstart;
        endx = xend;

        integral = Calc.areaUnder(a, b, c, d, e, f, xstart, xend);

        renderInt(intMode, intAmount, a, b, c, d, e, f);

        //previousy er variablen, der gemmer y-værdien fra forrige udregning. Se Calc.java på mere detalje om, hvordan denne her funktion fungerer
        float previousy = Calc.polyn(xstart, a, b, c, d, e, f);
        //Disse bruges til at finde funktionens ekstrenumpunkter indenfor rækkevidden. Defaulter til 0 fordi for x-aksen er praktisk når man
        //integrerer
        float highesty = 0, lowesty = 0;
        //newy gemmer værdien for den mest nylige udregning
        float newy;
        //Går vandret gennem alle 800 pixels på skærmen
        for(int i = 1; i < w; i++) {
            //omregner fra pixel på skærmen til dens tilsvarende matematiske værdi, hvorefter tilsvarende y-værdi udregnes
            newy = Calc.polyn(xToMath(i), a, b, c, d, e, f);
            
            if(newy * previousy < 0) {
                p.println("i og y: " + i + " og " + newy);
                endx = xToMath(i);
            }
            
            //Tegner en linje fra det sidste y til det nuværedne
            line(xToMath(i-1), previousy, xToMath(i), newy, 5);
            //Opdaterer previousy til det næste loop. Således dannes en kæde af streger, der former den endelige graf
            previousy = newy;
            //Søger ekstrenumpunkter
            if(newy > highesty) { highesty = newy; }
            if(newy < lowesty) { lowesty = newy; }
        }
        //Efter det hele er overstået, sættes grafens start- og slut- y-værdier til den øverste og nederste i funktionen
        starty = lowesty;
        endy = highesty;
        //Opdaterer forholdet mellem pixels og matematisk ændring
        xmult = w / (float)Math.abs(endx - startx);
        ymult = h / (float)Math.abs(endy - starty);

        //Debugging statements
        /*
        p.println("StartX - EndX: " + startx + " to " + endx);
        p.println("StartY - EndY: " + starty + " to " + endy);
        p.println("Xfactor Yfactor: " + xmult + " | " + ymult);
        */
        return endx;
    }

    public void display() {
        p.fill(255);
        p.strokeWeight(5);
        p.stroke(0);
        p.rect(x, y, w, h);
        drawAxes();
        drawLabels();
    }
}