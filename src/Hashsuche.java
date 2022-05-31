
public class Hashsuche {
    int modulo;
    static double[][] geburtsdaten;
    static int[] hash;
    static Hashsuche test;

    public static void main(String[] args) {
        setup();
        geburtswertEinfuegen(11031990, 9.8);
    }

    public static void setup(){
        test = new Hashsuche(11);
        geburtsdaten = new double[20][2];
        hash = new int[test.getModulo()];
    }

        public Hashsuche(int pModulo) {
            this.modulo = pModulo;
        }
        public int getModulo() {return this.modulo;}

    public static void hashEinfuegen(int pSchluessel) {
        hash[berechneHash(pSchluessel)] = pSchluessel;
        //TODO: Weitergabe ist inaktiv
    }
    public static int berechneHash(int pSchluessel) {
        return pSchluessel%test.getModulo();
    }

    public static void geburtswertEinfuegen(int pGeburtswert, double pValue) {
        for (double[] value : geburtsdaten) {
            if (value[0] == 0) {
                value[0] = pGeburtswert;
                value[1] = pValue;
                hashEinfuegen((int) value[0]);
                return;
            }
        }
    }

    public static void suche() {

    }
}
