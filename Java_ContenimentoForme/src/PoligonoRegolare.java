
/**
 * PoligonoRegolare è una classe che estende Forma. Questa classe contiene al suo interno tutti i metodi e gli attributi per lo sviluppo di questa tipologia di figura. Permette tramite l'utilizzo di una particolare
 * formula la costruzione di un poligono regolare e la determinazione dei suoi vertici partendo da n. lati.  Questo processo è stato attuato partendo dal valore del lato e dalle coordiante del
 * centro. Oltre alla relazione IS-A che lega questa classe con Forma, è presente una relazione di aggregazione lasca con Punto.
 * @author Diego De Leonardis
 * version 2.00, 15 Mar 2016
 */
public class PoligonoRegolare extends Forma {
    
    private Punto centro;
    
    private double lato;

    private double raggio;

    private Punto[] vertici;
    
    private int nLati;

    /**
     * Crea un'istanza di PoligonoRegolare. Oltre a inizializzare gli attributi dati in ingresso, questo costruttore ha la funzione di calcolo dei vertici, tramite apposita formula, e istanziamento
     * della BoundingBox. Questo metodo è la parte fondamentale della classe.
     * @param id parametro che deve essere assegnato all'attributo id (richiamando il costruttore della classe madre)
     * @param centro parametro che deve essere assegnato all'attributo centro
     * @param lato parametro che deve essere assegnato all'attributo lato
     * @param nLati parametro che deve essere assegnato all'attributo nLati
     */
    public PoligonoRegolare(String id, Punto centro, double lato, int nLati) {
        super(id);
        
        this.centro = new Punto(centro.getX(), centro.getY());
        this.lato = lato;
        this.raggio = lato / (2 * Math.sin((double) 1/ nLati * Math.PI));
        this.nLati = nLati;
        this.vertici = new Punto[nLati];
        
        if((this.nLati % 2) == 0) {
            for(int i = 0; i < nLati; i++)
                this.vertici[i] = new Punto(this.centro.getX() + this.raggio * Math.cos((2*Math.PI*i+ 1 * Math.PI)/this.nLati), this.centro.getY() + this.raggio * Math.sin((2*Math.PI*i+1 * Math.PI)/this.nLati));
        }
        else {
            for(int i = 0; i < nLati; i++)
                this.vertici[i] = new Punto(this.centro.getX() + this.raggio * Math.cos((2*Math.PI*i)/this.nLati + 0.5 * Math.PI), this.centro.getY() + this.raggio * Math.sin((2*Math.PI*i)/this.nLati + 0.5 * Math.PI));
        }
        
        int i = 0;
        
        double xMin = this.vertici[i].getX(), xMax = this.vertici[i].getX();
        double yMin = this.vertici[i].getY(), yMax = this.vertici[i].getY();
        
        for(; i < this.nLati; i++) {
            if(this.vertici[i].getX() < xMin)
                xMin = this.vertici[i].getX();
            
            if(this.vertici[i].getX() > xMax)
                xMax = this.vertici[i].getX();
            
            if(this.vertici[i].getY() < yMin)
                yMin = this.vertici[i].getY();
            
            if(this.vertici[i].getY() > yMax)
                yMax = this.vertici[i].getY();
        }
        this.bb = new BoundingBox(xMin, xMax, yMin, yMax);
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

    /**
     * Getters di un elemento del vettore vertici[nLati].
     * @param i indice dell'elemento che il metodo deve restituire
     * @return elemento con indice i del vettore vertici (attributo privato)
     */
    public Punto getVertice(int i) {
        return this.vertici[i];
    }

    @Override
    public String toString() {
        char c = 'A';
        String stringa = "Forma \"" + this.id + "\":\n\t- ID: " + this.id + "\n\t- Centro: " + this.centro.toString() + "\n\t- Lato: " + (float) this.lato + "\n\t- Raggio: " + (float) this.raggio + "\n\t- Numero di lati: " + this.nLati + "\n\t- Vertici:\n";
        for(int i = 0; i < this.nLati; i++) {
            stringa += "\t\t- Vertici " + (char) (c+i) + this.vertici[i].toString() +  "\n";
        }
        return stringa + "\t- Bounding Box:\n" + this.bb.toString();
    }
    
}
