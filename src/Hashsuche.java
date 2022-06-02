import java.util.Arrays;

public class Hashsuche {
    int modulo; //Teiler
    static double[] geburtsdaten; //speichert die hauptwerte
    static int[] hashTabelle; //speichert die werte am passenden Hash-Slot
    static Hashsuche test;

    public static void main(String[] args) {
        setup();
        for(int i=0; i<geburtsdaten.length+1; i++) geburtswertEinfuegen(11031990, 9);
        ausgabeGeburtswerte();
        ausgabeHashTabelle();
    }

    public static void setup(){
        test = new Hashsuche(11);
        geburtsdaten = new double[test.getModulo()];
        hashTabelle = new int[test.getModulo()];
    }

        public Hashsuche(int pModulo) {this.modulo = pModulo;}
        public int getModulo() {return this.modulo;}

    public static int hashEinfuegen(int pSchluessel) {
        int hash = berechneHash(pSchluessel);
        return rekEinfuegen(hash, pSchluessel, 0);
    }

    public static int rekEinfuegen(int index, int pSchluessel, int kollisionen) {
        if (kollisionen > hashTabelle.length) return -1; //wenn die Tabelle einmal komplett durchgegangen wurde wird abgebrochen
        if (index == hashTabelle.length) index -= hashTabelle.length; //wenn der Index das Array verlassen würde wird er ans linke Ende gesetzt
        if (hashTabelle[index] == 0) { //wenn der Slot leer ist
            hashTabelle[index] = pSchluessel; //wird der Wert in der Hashtabelle gespeichert
            return index; //und der Index zurückgegeben, damit in der Wertetabelle an der gleichen Stelle gespeichert wird
        }
        else return rekEinfuegen(index+1, pSchluessel, kollisionen+1); //sonst wird der nächste Aufruf der Methode mit einer Kollision mehr und einem erhöhten Index gemacht
    }
    public static int berechneHash(int pSchluessel) {return pSchluessel%test.getModulo();}

    public static void geburtswertEinfuegen(int pGeburtswert, double pValue) {
        int pos = hashEinfuegen(pGeburtswert); //speichert den Index des Wertes ab, um in der Wertetabelle an der gleichen Stelle zu speichern
        if (pos == -1) return; //wenn das einfügen nicht erfolgreich war wird nichts in die Wertetabelle eingefügt
        geburtsdaten[pos] = pValue;
    }

    public static void ausgabeGeburtswerte() {System.out.print(Arrays.toString(geburtsdaten)+"\n"); //gibt das gesamte Array auf der Konsole aus
    }

    public static void ausgabeHashTabelle() {System.out.print(Arrays.toString(hashTabelle)+"\n");} //gibt das gesamte Array auf der Konsole aus

    public static int suchePositionVon(int pGeburtswert) {
        //Findet von einem Geburtswert den Index in der Hastabelle, um den Wert in der Wertetabelle zuordnen zu können
        int hash = berechneHash(pGeburtswert);

        return -1;
        //TODO: Suche implementieren
    }
}
