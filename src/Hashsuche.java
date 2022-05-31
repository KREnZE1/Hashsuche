import java.util.Arrays;

public class Hashsuche {
    int modulo;
    static double[][] geburtsdaten;
    static int[] hashTabelle;
    static Hashsuche test;

    public static void main(String[] args) {
        setup();
        geburtswertEinfuegen(11031990, 9.8);
        geburtswertEinfuegen(11031990, 9.9);
    }

    public static void setup(){
        test = new Hashsuche(11);
        geburtsdaten = new double[20][2];
        hashTabelle = new int[test.getModulo()];
    }

        public Hashsuche(int pModulo) {
            this.modulo = pModulo;
        }
        public int getModulo() {return this.modulo;}

    public static void hashEinfuegen(int pSchluessel) {
        //hashTabelle[berechneHash(pSchluessel)] = pSchluessel;
        int hash = berechneHash(pSchluessel);
        rekEinfuegen(hash, pSchluessel, 0);
    }

    public static void rekEinfuegen(int index, int pSchluessel, int kollisionen) {
        if (kollisionen < hashTabelle.length) return;
        if (index > hashTabelle.length) index -= kollisionen;
        if (hashTabelle[index] == 0) {
            hashTabelle[index] = pSchluessel;
            System.out.println("Success");
            //noinspection UnnecessaryReturnStatement
            return;
        }
        else rekEinfuegen(index+1, pSchluessel, kollisionen+1);
        //TODO: Extensive testing necessary
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

    public static void ausgabeGeburtswerte() {
        for (double[] values : geburtsdaten) Arrays.toString(values);
    }

    public static void ausgabeHashTabelle() {
        Arrays.toString(hashTabelle);
    }
}
