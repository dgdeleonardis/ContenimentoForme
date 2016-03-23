import java.util.*;

/**
 * Main è una classe che contiene all'interno il metodo main, necessario per l'avvio del programma.
 * @author Diego De Leonardis
 * version 2.00, 23 Mar 2016
 */
public class Main {
    
    /**
     * Questo metodo ha la funzione di sviluppare il programma in maniera chiara e semplice grazie all'utilizzo delle classi contenute nel progetto, in particolare
     * la classe Menu e i suoi metodi statici.
     * @param args argomenti da riga di comando
     */
    public static void main(String[] args) {
        ArrayList<Forma> listaForme = new ArrayList();
        int opzione;
        
        do {
            Menu.menu();
            opzione = Input.readInt();
            
            switch(opzione) {
                case 1:
                    System.out.print("\n\nOPZIONE 1\n");
                    Menu.aggiungiForma(listaForme);
                    break;
                    
                case 2:
                    System.out.print("\n\nOPZIONE 2\n");
                    Menu.verificaContenimento(listaForme);
                    break;
                    
                case 3:
                    System.out.print("\n\nOPZIONE 3\n");
                    Menu.visualizzaDati(listaForme);
                    break;
                    
                case 4:
                    System.out.print("\n\nOPZIONE 4\nProgramma in arresto ...\n");
                    break;
                    
                default:
                    System.out.print("OPZIONE non disponibile\n\n");
        }
    } while(opzione != 4);
        
    System.out.println("**********************************************************\nPROGRAMMA TERMINATO");
    }
    
}
    
