
package es.unileon.prg1.masterMind;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
*@author Monica, Manuel, Cesar, Alfonso
*/

public class MainMastermind {
	 static final Logger logger = LogManager.getLogger(MainMastermind.class);
/**
 * 
 * @param args
 * @throws Exception
 */
    public static void main(String[] args) throws Exception {

        if (args.length != 3) {
        	throw new MasterMindException("Numero erroneo de argumentos");
        }
        

        String longitudCombinacion = args[0];
        String numeroIntentos = args[1];
        String coloresRepes = args[2]; 

        //Miro a ver si no me salta ninguna excepcion
        int longitudComb = verificarEnteros(longitudCombinacion);
        int numIntentos = verificarEnteros(numeroIntentos);
        boolean coloresRepetidos = VerificarBooleanos(coloresRepes);
        Mastermind masterMind = new Mastermind(longitudComb, numIntentos, coloresRepetidos);
        UIMasterMind ui = new UIMasterMind(masterMind);
        ui.jugar();
       

    }
/**
 * 
 * @param argumento
 * @return entero
 * @throws MasterMindException
 */
    public static int verificarEnteros(String argumento) throws MasterMindException {
        int longitud = 0;
        //intenta leer un numero, si no es un numero, que salte a la excepcion 
        try {
            longitud = Integer.parseInt(argumento);
        } catch (Exception Excepcion) {
           throw new MasterMindException("El argumento debe de ser un numero.");
        }

        if (longitud < 1) {
        	throw new MasterMindException("El argumento debe de ser mayor que cero.");
        }
        return longitud;
    }
/**
 * @param argumento
 * @return boolean
 * @throws MasterMindException
 */
    public static boolean VerificarBooleanos(String argumento) throws MasterMindException {
        if (argumento.equalsIgnoreCase("true")) {
            return true;
        } else if (argumento.equalsIgnoreCase("false")) {
            return false;
        } else {
        	throw new MasterMindException("El argumento debe de ser un booleano.");
        }
       
    }

}
