
package es.unileon.prg1.masterMind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
*@author Monica, Manuel, Cesar, Alfonso
*/
public class Tablero {
	static final Logger logger = LogManager.getLogger(MainMastermind.class.getName());

	private Combinacion[] intentos;
	private Combinacion[] resultados;

	private int indiceIntentos;
/**
 * @param numIntentos
 * @param numFichas
 * @throws MasterMindException
 */
	public Tablero(int numIntentos, int numFichas) throws MasterMindException {
		logger.trace("Creo un tablero");
		
		this.intentos = new Combinacion[numIntentos];
		this.resultados = new Combinacion[numIntentos];
		this.indiceIntentos = numIntentos;
		
		//inicializo tablero

		String cadenaVacia= "";
		for (int i = 0; i < numFichas; i++) {
			cadenaVacia+="-";
		}
		Combinacion combiVacia= new Combinacion(cadenaVacia, numFichas);
		for (int i = 0; i < intentos.length; i++) {
			intentos[i]=combiVacia;
			resultados[i]=combiVacia;
		}

	}
/**
 * @return numIntentos
 */
	public int getIntentos() {
		logger.trace("Me informo de la longitud del tablero.");
		return intentos.length;
	}


/**
 * @param intento
 * @param testigo
 */
	public void colocar(Combinacion intento, Combinacion testigo) {
		logger.trace("Coloco las combinacion en el tablero.");
		this.intentos[indiceIntentos-1] = intento;
		this.resultados[indiceIntentos-1]=testigo;

		indiceIntentos--;
	}


/**
 * @return String
 */
	public String toString() {
		logger.trace("Leo el tablero.");
		String cadena="";
		for (int i = 0; i < this.intentos.length; i++) {
			cadena+=this.intentos[i].toString();
			cadena+= " ";
			cadena+=this.resultados[i].toString();
			cadena+="\n";

		}
		return cadena;
	}

/**
 * @param testigo
 * @return boolean
 */
	public boolean esTodoCorrecto(Combinacion testigo) { 
		logger.trace("Miro si la combinacion de resultados es todo 'O'");
		boolean FichaTestigo=false;
		for (int i = 0; i <testigo.getLength(); i++) {
			if(testigo!=null){
				if(testigo.esTodoB()){
					FichaTestigo=true;  
					break;
				}
			}

		}

		return FichaTestigo;

	}

/**
 * @param indice
 * @param secreta
 * @return Combinacion
 * @throws MasterMindException
 */
	public Combinacion comparar(int indice,Combinacion secreta) throws MasterMindException{
		logger.trace("Comparo las dos combinaciones de los tableros.");
		Combinacion testigo=null;
		secreta.comparar(this.intentos[indice]);

		return testigo;

	}



}

