
/**
 * Forma è una classe astratta che è stata progettata come classe madre di ogni tipo di figura implementata nel progetto.
 * E' una classe che permette ulteriori ampliamenti del programma senza la modifica o aggiunta di attributi e metodi contenuti in essa.
 * @author Diego De Leonardis
 * @version 1.00, 07 Mar 2016
 */
public abstract class Forma {
    
    /**
     * Stringa che viene utilizzata come identificatore per l'utente della figura.
     */
    protected String id;

    /**
     * Istanza della classe BoundingBox. Relazione d'aggregazione stretta (ogni istanza di forma può contenere solo un'istanza di BoundingBox).
     */
    protected BoundingBox bb;
    
    /**
     * Crea un'istanza di Forma inizializzando l'attributo id.
     * @param id parametro che deve essere assegnato all'attributo id
     */
    public Forma(String id) {
        this.id = id;
    }

    /**
     * Verifica il contenimento di una forma (passata come parametro al metodo) nella figura del metodo invocato (this).
     * @param forma istanza di forma
     * @return valore booleano che sta ad indicare se forma è contenuto nella figura del metodo invocato
     */
    public boolean contiene(Forma forma) {
        if(!(((this.bb.getXMin() < forma.bb.getXMin()) && (forma.bb.getXMax() < this.bb.getXMax())) && ((this.bb.getYMin()< forma.bb.getYMin()) && (forma.bb.getYMax()< this.bb.getYMax()))))
            return false;
        return true;
    }
    
    /**
     * Metodo getters dell'attributo id.
     * @return attributo privato id.
     */
    public String getId() {
        return this.id;
    }
    
}
