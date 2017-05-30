
package es.unileon.prg1.masterMind;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
*@author Monica, Manuel, Cesar, Alfonso
*/
public class Mastermind {
	static final Logger logger = LogManager.getLogger(MainMastermind.class.getName());

	private Tablero tablero;
	private Combinacion combinacionSecreta;
/**
 * 
 * @param numIntentos
 * @param numFichas
 * @param conRepeticion
 * @throws MasterMindException
 */
	public Mastermind(int numIntentos, int numFichas, boolean conRepeticion) throws MasterMindException {
		logger.trace("Creo un mastermind.");		
		this.tablero = new Tablero(numIntentos, numFichas);
		this.combinacionSecreta = new Combinacion(numFichas, conRepeticion);
	}

/**
 * 
 * @param intento
 * @param testigo
 */
	public void colocar(Combinacion intento, Combinacion testigo) {
		logger.trace("Coloco una combinacion en el tablero.");
		this.tablero.colocar(intento, testigo);
	}
	/**
	 * @return String
	 */
	public String toString () {
		
		return this.combinacionSecreta.toString() + "\n" + this.tablero.toString();
	}

/**
 * 
 * @param intento
 * @return Combinacion
 * @throws MasterMindException
 */

	public Combinacion comparar(Combinacion intento) throws MasterMindException {
		Combinacion testigo = this.combinacionSecreta.comparar(intento);
		return testigo;
	}
	
/**
 * @param secreta
 */
	public void setCombinacionSecreta(Combinacion secreta){
		this.combinacionSecreta=secreta;
	}

/**
 * 
 * @param testigo
 * @return boolean
 */
	public boolean esTodoCorrecto(Combinacion testigo) {
		boolean fichaIgual=false;

		fichaIgual=this.tablero.esTodoCorrecto(testigo);


		return fichaIgual;
	}

/**
 * 
 * @return Tablero
 */
	public Tablero getTablero(){
		return this.tablero;
	}

/**
 * 
 * @return Combinacion
 */
	public Combinacion getCombinacionSecreta(){
		
		return this.combinacionSecreta;
	}

}
