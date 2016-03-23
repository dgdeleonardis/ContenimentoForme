
/**
 * BoundingBox è una classe che permette di semplificare la verifica del contenuto di una forma in un'altra. Fondamentalmente ogni istanza di questa classe contiene i valori maggiori e minori
 * di x e y di una data figura. Questa è legata alla classe Forma da una relazione d'aggregazione stretta (la classe Forma contiene solo un'istanza di BoundingBox). All'interno della classe non sono
 * presenti metodi particolari, ma solamente il costruttore e i vari getters degli attributi.
 * @author Diego De Leonardis
 * version 1.00, 07 Mar 2016
 */
public class BoundingBox {
    
    private double xMin;

    private double xMax;

    private double yMin;

    private double yMax;

    /**
     * Crea in'istanza di BoundingBox inizializzando tutti gli attributi con i valori dati in ingresso al metodo.
     * @param xMin parametro che deve essere assegnato all'attributo xMin
     * @param xMax parametro che deve essere assegnato all'attributo xMax
     * @param yMin parametro che deve essere assegnato all'attributo yMin
     * @param yMax parametro che deve essere assegnato all'attributo yMax
     */
    public BoundingBox(double xMin, double xMax, double yMin, double yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    /**
     * Getters dell'attributo xMin.
     * @return attributo privato xMin
     */
    public double getXMin() {
        return this.xMin;
    }

    /**
     * Getters dell'attributo xMax.
     * @return attributo privato xMax
     */
    public double getXMax() {
        return this.xMax;
    }

    /**
     * Getters dell'attributo yMin.
     * @return attributo privato yMin
     */
    public double getYMin() {
        return this.yMin;
    }

    /**
     * Getters dell'attributo yMax.
     * @return attributo privato yMax
     */
    public double getYMax() {
        return this.yMax;
    }

    @Override
    public String toString() {
        return "\t\t- xMin: " + (float) this.xMin + "\n\t\t- xMax: " + (float) this.xMax + "\n\t\t- yMin: " + (float) this.yMin + "\n\t\t- yMax: " + (float) this.yMax;
    }

}
