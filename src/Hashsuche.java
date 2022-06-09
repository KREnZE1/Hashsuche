import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hashsuche {
    int modulo; //Teiler
    static double[] geburtsdaten; //speichert die Hauptwerte
    static int[] hashTabelle; //speichert die werte am passenden Hash-Slot
    static Hashsuche test;
    static int hash;
    static BufferedReader br;
    static int gb;
    static double val;

    public static void main(String[] args) throws IOException {
        setup();
        getInput();
        ausgabeGeburtswerte();
        ausgabeHashTabelle();
    }

    public static void setup(){
        test = new Hashsuche(11);
        geburtsdaten = new double[test.getModulo()];
        hashTabelle = new int[test.getModulo()];
        br = new BufferedReader(new InputStreamReader(System.in));
    }

        public Hashsuche(int pModulo) {this.modulo = pModulo;}
        public int getModulo() {return this.modulo;}

    public static int hashEinfuegen(int pSchluessel) {
        int hash = berechneHash(pSchluessel);
        return rekEinfuegen(hash, pSchluessel, 0);
    }

    public static int rekEinfuegen(int index, int pSchluessel, int kollisionen) {
        if (kollisionen > hashTabelle.length) return -1; //wenn die Tabelle einmal komplett durchgegangen wurde, wird abgebrochen
        if (index == hashTabelle.length) index -= hashTabelle.length; //wenn der Index das Array verlassen würde, wird er ans linke Ende gesetzt
        if (hashTabelle[index] == 0) { //wenn der Slot leer ist
            hashTabelle[index] = pSchluessel; //wird der Wert in der Hashtabelle gespeichert
            return index; //und der Index zurückgegeben, damit in der Wertetabelle an der gleichen Stelle gespeichert wird
        }
        else return rekEinfuegen(index+1, pSchluessel, kollisionen+1); //sonst wird der nächste Aufruf der Methode mit einer Kollision mehr und einem erhöhten Index gemacht
    }
    public static int berechneHash(int pSchluessel) {return pSchluessel%test.getModulo();}

    public static void geburtswertEinfuegen(int pGeburtswert, double pValue) {
        int pos = hashEinfuegen(pGeburtswert); //speichert den Index des Wertes ab, um in der Wertetabelle an der gleichen Stelle zu speichern
        if (pos == -1) return; //wenn das Einfügen nicht erfolgreich war, wird nichts in die Wertetabelle eingefügt
        geburtsdaten[pos] = pValue;
    }

    public static void ausgabeGeburtswerte() {System.out.print(Arrays.toString(geburtsdaten)+"\n"); //gibt das gesamte Array auf der Konsole aus
    }

    public static void ausgabeHashTabelle() {System.out.print(Arrays.toString(hashTabelle)+"\n");} //gibt das gesamte Array auf der Konsole aus

    public static int suchePositionVon(int pGeburtswert) {
        //Findet von einem Geburtswert den Index in der Hashtabelle, um den Wert in der Wertetabelle zuordnen zu können
        hash = berechneHash(pGeburtswert);
        return rekSuche(hash, pGeburtswert, 0)+hash;
        //TODO: Suche improven, funktioniert noch nicht
    }

    public static int rekSuche(int index, int pValue, int kollisionen) {
        if (kollisionen > hashTabelle.length) return -1; //wenn die Tabelle einmal komplett durchgegangen wurde, wird abgebrochen
        if (index == hashTabelle.length) index -= hashTabelle.length; //wenn der Index das Array verlassen würde, wird er ans linke Ende gesetzt
        if (hashTabelle[index] == pValue) { //wenn der Slot mit dem richtigen Wert gefüllt ist
            return index; //wird der Index zurückgegeben
        }
        else return rekEinfuegen(index+1, pValue, kollisionen+1); //sonst wird der nächste Aufruf der Methode mit einer Kollision mehr und einem erhöhten Index gemacht
    }

    public static void getInput() throws IOException {
        System.out.print("Geburtsdatum: ");
        gb = Integer.parseInt(br.readLine());
        System.out.print("Wert: ");
        val = Double.parseDouble(br.readLine());
        geburtswertEinfuegen(gb, val);
    }

    public static void loop() {
        System.out.println("Ausgabe: A");
        System.out.println("Eingabe E");
    }
}
