
/**
 * Cerchio è una classe che estende Forma. Questa classe contiene al suo interno tutti i metodi e gli attributi per lo sviluppo di un cerchio. Permette tramite l'utilizzo di una particolare
 * formula la costruzione di un cerchio partendo dal suo centro e raggio. Oltre alla relazione IS-A che lega questa classe con Forma, è presente una relazione d'aggreazione stretta con Punto.
 * @author Diego Diego De Leonardis
 * version 1.00, 07 Mar 2016
 */
public class Cerchio extends Forma {

    private Punto centro;

    private double raggio;

    /**
     * Crea un'istanza di Cerchio. Oltre a inizializzare gli attributi dati in ingresso, questo costruttore ha la funzione di calcolo e istanziamento
     * della BoundingBox. Questo metodo è la parte fondamentale della classe.
     * @param id parametro che deve essere assegnato all'attributo id (richiamando il costruttore della classe madre)
     * @param centro parametro che deve essere assegnato all'attributo centro
     * @param raggio parametro che deve essere assegnato all'attributo raggio
     */
    public Cerchio(String id, Punto centro, double raggio) {
        super(id);
        this.centro = centro;
        this.raggio = raggio;
        this.bb = new BoundingBox(this.centro.getX() - this.raggio, this.centro.getX() + this.raggio,this.centro.getY() - this.raggio, this.centro.getY() + this.raggio);
    }

    /**
     * Getters dell'attributo centro.
     * @return attributo privato centro
     */
    public Punto getCentro() {
        return this.centro;
    }

    /**
     * Getters dell'attributo raggio.
     * @return attributo privato raggio
     */
    public double getRaggio() {
        return this.raggio;
    }
    
    @Override
    public String toString() {
        return "Forma \"" + this.id + "\":\n\t- ID: " + this.id + "\n\t- Centro: " + this.centro.toString() + "\n\t- Raggio: " + (float) this.raggio + "\n\t- Bounding Box:\n" + this.bb.toString(); 
    }
    
}
