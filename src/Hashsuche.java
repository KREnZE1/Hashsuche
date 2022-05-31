
public class Hashsuche {
    int modulo;
    static double[][] geburtsdaten;
    static int[] hash;
    static Hashsuche test;

    public static void main(String[] args) {
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
    }
    public static int berechneHash(int pSchluessel) {
        return pSchluessel%test.getModulo();
    }

}
