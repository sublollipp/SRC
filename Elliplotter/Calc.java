import java.lang.Math;

public abstract class Calc {

    //At en klasses funktion er "static" betyder, at man kan bruge den uden at skulle lave et objekt - altså bare yoinke den direkte fra selve classen.
    //Math.pow(a, b) funktionen sætter a i b'ne potens. De skal begge være doubles, har java bestemt sig for (fandt ud af det på nettet, brug Google!)
    //Den returner også en Double. Her hvis du vil læse: https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
    public static float polyn(double x, double a, double b, double c, double d, double e, double f) {
        //Jeg VIL HAVE en float, så jeg omdanner den fra double til float her, samtidig med, at jeg får computeren til at matematikke
        return (float)(a * Math.pow(x, 5) + b * Math.pow(x, 4) + c * Math.pow(x, 3) + d * Math.pow(x, 2) + e * x + f);
    }

    //ax^5+bx^4+cx^3+dx^2+ex+f
    public static float stamfunktion(double a, double b, double c, double d, double e, double f, double x) {
        return (float)((Math.pow(x, 6) / 6) * a + (Math.pow(x, 5) / 5) * b + (Math.pow(x, 4) / 4) * c + (Math.pow(x, 3) / 3) * d + (Math.pow(x, 2) / 2) * e + f * x);
    }

    public static float areaUnder(double a, double b, double c, double d, double e, double f, double xstart, double xend) {
        //STAMFUNKTIONNN
        return Math.abs(stamfunktion(a, b, c, d, e, f, xstart) - stamfunktion(a, b, c, d, e, f, xend));
    }
}