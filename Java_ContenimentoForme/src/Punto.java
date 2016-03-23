
/**
 * Punto è una classe utilizzata nelle classi che estendono Forma come entità che permette di descrivere un punto sul piano cartesiano. E' una classe molto semplice che ha come attributi
 * le coordinate x e y del punto e i metodi getters rispettivi.
 * @author Diego
 */
public class Punto {

    private double x;

    private double y;

    /**
     * Crea un'istanza di Punto, inizializzando gli attributi con i valori dati in ingresso.
     * @param x parametro che deve essere assegnato all'attributo x
     * @param y parametro che deve essere assegnato all'attributo y
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getters dell'attributo x.
     * @return attributo privato x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getters dell'attributo y.
     * @return attributo privato y
     */
    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + (float) this.x + "," + (float) this.y + ")";
    }
    
}
