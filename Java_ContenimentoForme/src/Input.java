import java.io.*;

/**
 * Input è una classe composta da soli metodi statici e da un attributo, anche esso statico, che permettono di non instanziare almeno un'instanza della classe per utilizzarne i metodi. Contiene tutti metodi inerenti all'input
 * e un attributo che ha la funzione di flag nel caso ci siano errori di inserimento. La scopo principale della classe è quello di offrire al programmatore dei metodi funzionanti che racchiudono in se tutte le istruzioni
 * per l'input da tastiera da terminale.
 * @author Diego De Leonardis
 * version 2.00, 23 Mar 2016
 */
public class Input {
    
    private static boolean flag;

    /**
     * Getters dell'attributo statico flag.
     * @return attributo privato statico flag
     */
    public static boolean isFlag() {
        return flag;
    }

    /**
     * Resetta l'attributo privato statico flag, impostandolo a valore false.
     */
    public static void resetFlag() {
        Input.flag = false;
    }
    
    /**
     * Legge una stringa da tastiera e la resituisce.
     * @return stringa letta da tastiera
     */
    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        
        try {
            return tastiera.readLine();
        }
        catch(Exception e){
            System.out.println("ERRORE d'inserimento");
            Input.flag = true;
            return null;
        }
    }
    
    /**
     * Legge un valore int da tastiera e lo restituisce.
     * @return int letto da tastiera
     */
    public static int readInt() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        
        try {
            return Integer.valueOf(tastiera.readLine());
        }
        catch(IOException | NumberFormatException e){
            System.out.println("ERRORE d'inserimento");
            Input.flag = true;
            return 0;
        }
        
        
    }
    
    /**
     * Legge un valore float da tastiera e lo restituisce.
     * @return float letto da tastiera
     */
    public static float readFloat() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        
        try {
            return Float.valueOf(tastiera.readLine());
        }
        catch(IOException | NumberFormatException e){
            System.out.println("ERRORE d'inserimento");
            Input.flag = true;
            return 0;
        }
    }
    
    /**
     * Legge un valore double da tastiera e lo restituisce.
     * @return double letto da tastiera
     */
    public static double readDouble() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        
        try {
            tastiera.readLine();
            return Double.valueOf(tastiera.readLine());
        }
        catch(IOException | NumberFormatException e){
            System.out.println("ERRORE d'inserimento");
            Input.flag = true;
            return 0;
        }
    }
    
}
