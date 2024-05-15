import java.lang.Math;

public abstract class Calc {

    //At en klasses funktion er "static" betyder, at man kan bruge den uden at skulle lave et objekt - altså bare yoinke den direkte fra selve classen.
    //Math.pow(a, b) funktionen sætter a i b'ne potens. De skal begge være doubles, har java bestemt sig for (fandt ud af det på nettet, brug Google!)
    //Den returner også en Double. Her hvis du vil læse: https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
    public static float polyn(double x, double a, double b, double c, double d, double e, double f) {
        //Jeg VIL HAVE en float, så jeg omdanner den fra double til float her, samtidig med, at jeg får computeren til at matematikke
        return (float)(a * Math.pow(x, 2) + b * x + c + d * Math.pow(x, 3) + e * Math.pow(x, 4) + f * Math.pow(x, 5));
    }
}