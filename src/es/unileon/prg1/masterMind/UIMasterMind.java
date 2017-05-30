
package es.unileon.prg1.masterMind;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
*@author Monica, Manuel, Cesar, Alfonso
*/
public class UIMasterMind {
	static final Logger logger = LogManager.getLogger(MainMastermind.class.getName());

    private Mastermind mastermind;
   
  
/**
 * @param mastermind
 */
    public UIMasterMind(Mastermind mastermind){
        this.mastermind = mastermind;
    }

    /**
     * @throws Exception
     */
    
    public void jugar() throws Exception {
    logger.trace("Empiezo a jugar en el juego.");
        boolean conseguido = false;
        System.out.print(this.mastermind.toString());
        for (int i = 0; i < mastermind.getTablero().getIntentos(); i++) {
        	logger.trace("Pido la pimera combinacion.");
            Combinacion intento = pedirCombinacion();
           
            
            Combinacion testigo = this.mastermind.comparar(intento);
            this.mastermind.colocar(intento, testigo);
           // System.out.println(mastermind.getCombinacionSecreta().toString()); 
            System.out.print(this.mastermind.toString());
           // System.out.println(testigo.toString());
            if (this.mastermind.esTodoCorrecto(testigo)) {
                conseguido = true;
                break;
            }
        }
        if (conseguido) {
        	 System.out.println("Enhorabuena! Has acertado.");
        	 System.exit(0);
        } else {
        	 System.out.println("Lo sentimos, se han acabado los intentos.");
        	 System.exit(0);
        }
    }

     /**
     * 
     * @return Combinacion
     * @throws Exception
     */
    public Combinacion pedirCombinacion() throws Exception {
        System.out.println("Introducir una combinacion de 4 colores: R/G/Y/B/P/C/salir : ");
    	String dato = "";
        Combinacion combinacion = null;
        try{
        	dato = Teclado.readString();
        }catch(Exception MasterMindException){
        	throw new MasterMindException("Se ha producido un error al leer.");
        }
            
        dato=dato.toUpperCase();
        
        if(dato.equals("SALIR")){
            logger.trace("Salgo del juego.");
        	System.out.println("Fin del juego.");
        	System.exit(0);
        }
        
        combinacion=new Combinacion(dato, dato.length());
        return combinacion;
    }

}
