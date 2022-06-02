import java.util.Arrays;

public class Hashsuche {
    int modulo;
    static double[] geburtsdaten;
    static int[] hashTabelle;
    static Hashsuche test;

    public static void main(String[] args) {
        setup();
        geburtswertEinfuegen(11031990, 9.8);
        geburtswertEinfuegen(11031990, 9.9);
        ausgabeGeburtswerte();
        ausgabeHashTabelle();
    }

    public static void setup(){
        test = new Hashsuche(11);
        geburtsdaten = new double[test.getModulo()];
        hashTabelle = new int[test.getModulo()];
    }

        public Hashsuche(int pModulo) {
            this.modulo = pModulo;
        }
        public int getModulo() {return this.modulo;}

    public static int hashEinfuegen(int pSchluessel) {
        int hash = berechneHash(pSchluessel);
        return rekEinfuegen(hash, pSchluessel, 0);
    }

    public static int rekEinfuegen(int index, int pSchluessel, int kollisionen) {
        if (kollisionen > hashTabelle.length) return -1;
        if (index > hashTabelle.length) index -= hashTabelle.length;
        if (hashTabelle[index] == 0) {
            hashTabelle[index] = pSchluessel;
            return index;
        }
        else return rekEinfuegen(index+1, pSchluessel, kollisionen+1);
    }
    public static int berechneHash(int pSchluessel) {return pSchluessel%test.getModulo();}

    public static void geburtswertEinfuegen(int pGeburtswert, double pValue) {
        geburtsdaten[hashEinfuegen(pGeburtswert)] = pValue;
    }

    public static void ausgabeGeburtswerte() {System.out.print(Arrays.toString(geburtsdaten)+"\n");
    }

    public static void ausgabeHashTabelle() {System.out.print(Arrays.toString(hashTabelle)+"\n");}

    public static int suchePositionVon(int pGeburtswert) {
        //Eingabe ein Geburtswert, Ausgabe der index in der hashtabelle (was der index in der normalen tabelle ist)

        return -1;
        //TODO: Suche implementieren
    }
}
