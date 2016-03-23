import java.util.ArrayList;

/**
 * Menu è una classe progettata come contenitrice di tutti i metodi che gesticono le opzioni e l'interfacciamento con l'utente. Tutti i metodi sono statici in modo tale da
 * non rendere necessario l'istanziamento nessun oggetto di questa classe. Questa è stata progettata con l'obiettivo di rendere il metodo main della classe Main il più possibile
 * semplice e chiaro. Tale classe può essere modificata e aggiornata con ulteriori metodi che possono aumentare le funzionalità del programma, senza andare a modificare in modo eccessivo
 * il metodo main.
 * @author Diego De Leonardis
 * version 2.00, 23 Mar 2016
 */
public class Menu {

    /**
     * Stampa il menù del programma con tutte le opzioni che l'utente può scegliere.
     */
    public static void menu() {
        System.out.print("***************** CONTENIMENTO FORMA v1.0 *****************\n"
                         + "1. Inserisci una forma\n"
                         + "2. Verifica il contenimento di una forma in un'altra\n"
                         + "3. Visualizza i dati di una forma\n"
                         + "4. Termina programma\n"
                         + "**********************************************************\n"
                         + "Inserisci un'opzione : ");
    }
   
    /**
     * Aggiunge una forma all'array dinamico passato come parametro. In base alla scelta dell'utente vengono richiesti i campi necessari per la figura scelta e viene invocato il costruttore
     * corrispettivo.
     * @param array struttura dinamica dove vengono poste tutte le figure
     */
    public static void aggiungiForma(ArrayList<Forma> array) {
        Input.resetFlag();
        int opzione, nLati;
        double raggio, lato, x, y;
        String id;
        
        System.out.print("**********************************************************\n"
                         + "Elenco forme: \n"
                         + "1. Poligono Regolare di n. lati;\n"
                         + "2. Cerchio;\n"
                         + "**********************************************************\n"
                         + "Inserisci un'opzione : ");
        
        opzione = Input.readInt();
        
        switch(opzione) {
            case 1:
                System.out.print("\n\n- Identificatore poligono : ");
                id = Input.readString();
                System.out.print("- Numero lati poligono : ");
                nLati = Input.readInt();
                System.out.print("- Lato del poligono : ");
                lato = Input.readDouble();
                System.out.print("- Coordinate del centro\n\t- X : ");
                x = Input.readDouble();
                System.out.print("\t- Y : ");
                y = Input.readDouble();
                
                if(Input.isFlag() != true && nLati > 2 && lato > 0) {
                    array.add(new PoligonoRegolare(id, new Punto(x, y), lato, nLati));
                    System.out.print("Forma \"" + id + "\" aggiunta correttamente\n\n");
                }
                else
                    System.out.print("ERRORE durante l'inserimento dei dati: forma non creata\n\n");
                break;
                
            case 2:
                System.out.print("\n\n- Identificatore cerchio : ");
                id = Input.readString();
                System.out.print("- Raggio del cerchio : ");
                raggio = Input.readDouble();
                System.out.print("- Inserisci le coordinate del centro\n\t- X : ");
                x = Input.readDouble();
                System.out.print("\t- Y : ");
                y = Input.readDouble();
                
                if(Input.isFlag() != true && raggio > 0) {
                    array.add(new Cerchio(id, new Punto(x, y), raggio));
                    System.out.print("Forma \"" + id + "\" aggiunta correttamente\n\n");
                }
                else
                    System.out.print("ERRORE durante l'inserimento dei dati: forma non creata\n\n");
                break;
                
            default:
                System.out.print("Opzione non disponibile\n\n");
        }
    }
    
    /**
     * Verifica il contenuto di una figura su un'altra. Ha la funzione di interfacciamento con l'utente e richiesta degli id delle due figure su cui andare ad operare.
     * Scansiona la struttura dinamica data in ingresso (trasformata in statica) per estrarre i due elementi e verificarne il contenuto della seconda nella prima.
     * @param array struttura dinamica dove vengono poste tutte le figure
     */
    public static void verificaContenimento(ArrayList<Forma> array) {
        Input.resetFlag();
        Forma lista[] = array.toArray(new Forma[array.size()]);
        Forma OgContiene = null, OgContenuto = null;
        
        System.out.print("**********************************************************\n"
                         + "- Nome della forma che contiene : ");
        String contiene = Input.readString();
        
        System.out.print("- Nome della forma che è contenuta : ");
        String contenuto = Input.readString();
        
        if(Input.isFlag() != true) {
            for(int i = 0; i < array.size(); i++) {
                if(lista[i].getId().equals(contiene)) {
                    OgContiene = lista[i];
                    break;
                }
            }

            for(int i = 0; i < array.size(); i++) {
                if(lista[i].getId().equals(contenuto)) {
                    OgContenuto = lista[i];
                    break;
                }
            }
            
            if(OgContiene != null && OgContenuto != null)
                System.out.println("La forma \"" + contiene + "\" contiene la forma \"" + contenuto + "\" : " + OgContiene.contiene(OgContenuto) + "\n\n");
            else
                System.out.println("ERRORE druante la ricerca: forma/e non trovata/e\n\n");
        }
        else
            System.out.print("\nErrore durante l'inserimento dei dati: ricerca fallita\n\n");
    }
    
    /**
     * Visualizza i dati di una forma dell'array dinamico passato come parametro. Ha la funzione di interfacciamento con l'utente e richiesta dell'id della figura su cui andare ad operare.
     * Scansiona la struttura dinamica data in ingresso (trasformata in statica) per estrarre l'elemento da "visualizzare".
     * @param array Struttura dinamica dove vengono poste tutte le igure
     */
    public static void visualizzaDati(ArrayList<Forma> array) {
        Input.resetFlag();
        Forma lista[] = array.toArray(new Forma[array.size()]);
        Forma OgVisualizzato = null;
        
        System.out.print("**********************************************************\n"
                        + "-Nome della forma da ricercare : ");
        String stringa = Input.readString();
        
        if(!Input.isFlag()) {
            for(int i = 0; i < array.size(); i++) {
                if(lista[i].getId().equals(stringa)) {
                    OgVisualizzato = lista[i];
                    break;
                }
            }
            
            if(OgVisualizzato != null)
                System.out.print("\n" + OgVisualizzato.toString() + "\n\n");
            else
                System.out.print("\nERRORE durante la ricerca della forma: forma non trovata\n\n");
        }
        else
            System.out.print("\nErrore durante l'inserimento dei dati: ricerca fallita\n\n");
    }
    
}



