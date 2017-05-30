

package es.unileon.prg1.masterMind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
*@author Monica, Manuel, Cesar, Alfonso
*/
public class Ficha {
	 static final Logger logger = LogManager.getLogger(MainMastermind.class.getName());

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	private Colors color;

	public Ficha() {
		logger.trace("Creo una ficha.");
		String caracteresS = "RGYBPC";
		char colorAleatorio=caracteresS.charAt((int) (((caracteresS.length() - 1) - 0 + 1) * Math.random()) + 0);
		this.color = pasarCharAColor(colorAleatorio);


	}/**
	 * @param colorAleatorio
	 * @return Colors
	 */
	public Colors pasarCharAColor(char colorAleatorio) {
		Colors result = null;

		switch(colorAleatorio){
		case'O':	//negro
			result = Colors.BLACK;
			break;
		case 'R':
			result = Colors.RED;
			break;
		case 'G':
			result = Colors.GREEN;
			break;
		case 'Y': 
			result = Colors.YELLOW;
			break;
		case 'B':
			result = Colors.BLUE;
			break;
		case 'P':
			result = Colors.PURPLE;
			break;
		case 'C':
			result = Colors.CYAN;
			break;
		case 'X': 
			result = Colors.WHITE;
			break;
		default:
			result = Colors.NONE;
			break;
		}
		return result;

	}
	/**
	 * @param color
	 * @throws MasterMindException
	 */
	
	public Ficha(char color) throws MasterMindException{
		logger.trace("Creo una ficha");
		Colors colores=pasarCharAColor(color);
		this.setColor(colores);
	}
/**
 * 
 * @return Colors
 */
	public Colors getColor() {
		return this.color;
	}
/**
 * 
 * @param color
 * @throws MasterMindException
 */
	public void setColor(Colors color) throws MasterMindException{
		this.color = color;
	}    


/**
 * 
 * @param otraFicha
 * @return boolean
 */
	public boolean compararFicha(Ficha otraFicha) {
		logger.trace("Comparo dos fichas.");
		boolean esIgual = false;
		if (this.getColor() == otraFicha.getColor()) {
			esIgual = true;
		}
		return esIgual;
	}

/**
 * 
 * @return Colors
 */
	public Colors color() {

		String caracteresS = "LWRGYBPC";
		int indice = caracteresS.lastIndexOf(pasarColorAChar(this.color));
		Colors color = (Colors.values()[indice + 1]);

		return color;
	}
/**
 * 
 * @param color2
 * @return char
 */
	public char pasarColorAChar(Colors color2) {
		char result = '0';

		switch (color2){
		case BLACK:
			result = 'O';
			break;
		case RED:
			result ='R';
			break;
		case GREEN:
			result = 'G';
			break;
		case YELLOW: 
			result = 'Y';
			break;
		case BLUE:
			result = 'B';
			break;
		case PURPLE:
			result = 'P';
			break;
		case CYAN:
			result = 'C';
			break;
		case WHITE: 
			result = 'X';
			break;
		case NONE:
			result = '-';
			break;
		}
		return result;
	}
/**
 * 
 * @param color
 * @return String
 */
	public String pasarColorAString(Colors color) {
		String result = "";

		switch (color){
		case BLACK:
			result = "O";
			break;
		case RED:
			result ="R";
			break;
		case GREEN:
			result = "G";
			break;
		case YELLOW: 
			result = "Y";
			break;
		case BLUE:
			result = "B";
			break;
		case PURPLE:
			result = "P";
			break;
		case CYAN:
			result = "C";
			break;
		case WHITE: 
			result = "X";
			break;
		case NONE:
			result = "-";
			break;
		}
		return result;
	}
/**
 * 
 * @return char
 */
	public char getCaracter() {
		return pasarColorAChar(this.color);
	}
/**
 * 
 * @return String
 */
	public String getString(){
		return pasarColorAString(this.color); 
	}
/**
 * @return String
 */
	@Override
	public String toString(){
		String result = null;

		switch (this.color){
		case BLACK:
			result = ANSI_BLACK+"[O]"+ANSI_RESET;
			break;
		case RED:
			result = ANSI_RED+"[R]"+ANSI_RESET;
			break;
		case GREEN:
			result = ANSI_GREEN+"[G]"+ANSI_RESET;
			break;
		case YELLOW: 
			result = ANSI_YELLOW+"[Y]"+ANSI_RESET;
			break;
		case BLUE:
			result = ANSI_BLUE+"[B]"+ANSI_RESET;
			break;
		case PURPLE:
			result = ANSI_PURPLE+"[P]"+ANSI_RESET;
			break;
		case CYAN:
			result = ANSI_CYAN+"[C]"+ANSI_RESET;
			break;
		case WHITE: 
			result = ANSI_WHITE+"[X]"+ANSI_RESET;
			break; 
		case NONE:
			result = ANSI_BLACK+"-"+ANSI_RESET;
			break;
		}
		return result;
	}

}

