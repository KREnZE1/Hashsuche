public class Main {
    static double[][] werte;
    static int[] gehasht;
    static int modulo;

    public static void main(String[] args) {

    }

    public static int berechneHash(int pSchluessel) {
        //Hashwert aus einer Zahl berechnen
        return pSchluessel%modulo;
    }

    public static void fuegeEin(int pSchluessel, double wert) {
        //In Geburtswert Tabelle einfuegen
        for (int i=0; i<werte.length; i++){
            if (werte[i][0] == 0) {
                werte[i][0] = pSchluessel;
                werte[i][1] = wert;
            }
        }
    }

    public static int suchePositionVon(int pSchluessel) {
        //TODO: Methode schreiben
        return 0;
    }

    public static int fuegeEin(int pSchluessel) {
        //TODO: Methode schreiben
        //In Gehashte Tabelle einfuegen

        return 0;
    }

    public static double[][] gibWerte() {
        return werte;
    }

    public static int[] gibGehasht(){
        return gehasht;
    }

    public static double gibWertVonGeburtsdatum(int pGeburtsdatum) {
        for (double[] doubles : werte) {
            if (doubles[0] == pGeburtsdatum) return doubles[1];
        }
        System.out.println("ERROR");
        return -1;
    }
}