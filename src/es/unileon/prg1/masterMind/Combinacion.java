
package es.unileon.prg1.masterMind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
*@author Monica, Manuel, Cesar, Alfonso
*/
public class Combinacion {
	
	static final Logger logger = LogManager.getLogger(MainMastermind.class.getName());
	private Ficha[] fichas;
/**
 * @param longitud
 * @param siRepetir
 * @throws MasterMindException
 */
	public Combinacion(int longitud, boolean siRepetir) throws MasterMindException {
		logger.trace("Creo la combinacion secreta.");		
		this.fichas = new Ficha[longitud];
		String combinacion = "";
		String caracteresS = "RGYBPC";
		char caracter = 0;
		if (longitud > caracteresS.length() && !siRepetir) {
			siRepetir = true;
			System.out.println("hay que repetir colores por ser mayor la longitud que los colores diponibles");
		}
		if (!siRepetir) {	//si no se repiten
			for (int i = 0; i < longitud; i++) {
				do {
					caracter = caracteresS.charAt((int) (((caracteresS.length() - 1) - 0 + 1) * Math.random()) + 0);	//cojo un caracter aleatorio
				} while (combinacion.indexOf(caracter) != -1);	//hacer eso mientras que el caracter sea distinto de menos1
				combinacion += caracter;
			}
		} else {	//si se repiten...
			for (int i = 0; i < longitud; i++) {
				caracter = caracteresS.charAt((int) (((caracteresS.length() - 1) - 0 + 1) * Math.random()) + 0);
				combinacion += caracter;			//creo la cadena con la los colores
			}
		}
		for (int i = 0; i < fichas.length; i++) {
			fichas[i] = new Ficha(combinacion.charAt(i));	//creo el array de fichas de la cadena

		}

	}


/**
 * 
 * @param combinacion
 * @param longitudCombinacion
 * @throws MasterMindException
 */
	public Combinacion(String combinacion, int longitudCombinacion) throws MasterMindException{	//meto cada caracter de la cadena como una posicion de la combinacion
		logger.trace("Creo una combinacion.");		
		try{
			fichas=new Ficha[longitudCombinacion];
			char[] colores= combinacion.toCharArray();	//como split
			for (int i = 0; i < longitudCombinacion; i++) {
				Ficha ficha= new Ficha(colores[i]);
				fichas[i]=ficha;
			}
		}catch (Exception Excepcion) {
			throw new MasterMindException("El argumento no es valido.");
		}
	}

/**
 * 
 * @param intento
 * @return Combinacion
 * @throws MasterMindException
 */
	public Combinacion comparar(Combinacion intento) throws MasterMindException {
		logger.trace("Comparo dos combinaciones.");		
		try{
			//System.out.println("hola, aqui en clase combinacion: comparar:");
		
		//System.out.println("El  intento: "+intento.toString());
		//System.out.println("La secreta: "+ this.toString());
		String intentoS=intento.toStringBasic();
		
		String testigoS = "";
		int k = 0;
		String[] resul = null;
		//controlo que sea correcta 
		//System.out.println(intentoS+" mide :  "+intento.getLength());
		//System.out.println(this.toString()+" mide :  "+this.getLength());

		
			resul = new String[this.getLength()];	//inicio la el array de cadena a -
			for (int i = 0; i < resul.length; i++) {//creo array a _ _ 
				resul[i] = "-";

			}
			
			char[] intentoCombi = intentoS.toCharArray();				//marco el comparado en este array
			char[] combiSecre = this.toStringBasic().toCharArray();	//marco el comparado en este array



			//primera vuelta buscando los que estÃ¡n acertados en color y sitio
			for ( int i = 0; i < intentoCombi.length; i++) {
				if (String.valueOf(intentoCombi[i]).compareToIgnoreCase(String.valueOf(combiSecre[i])) == 0) {

					resul[k] = "O";
					k++;
					intentoCombi[i] = '*';		//lo marco como ya leido
					combiSecre[i] = '*';

				}

			}
			//segunda vuelta buscando color no colocado
			for ( int i = 0; i < intentoCombi.length; i++) {
				if (String.valueOf(intentoCombi[i]).compareToIgnoreCase("*") != 0) {
					for (int j = 0; j < combiSecre.length; j++) {

						if (String.valueOf(intentoCombi[i]).compareToIgnoreCase(String.valueOf(combiSecre[j])) == 0) {

							resul[k] = "X";
							k++;
							intentoCombi[i] = '*';//lo marco como ya leido
							combiSecre[j] = '*';
							break;
						}
						
					}
				}
			}
			for ( int i = 0; i < resul.length; i++) {
				testigoS += resul[i];	//lo uno todo en la string de testigoS
				//System.out.println(testigoS);
			}
		
		Combinacion testigo= new Combinacion(testigoS, fichas.length);
		return testigo;
		}catch(Exception Excepcion){
			throw new MasterMindException("Lo sentimos. Ha habido un error.");
		}
		
	}
/**
 * @return String
 */
	@Override
	public String toString() {
		String cadena = "";
		for (int i = 0; i < fichas.length; i++) {
			cadena += fichas[i].toString();
		}
		return cadena;
	}
	/**
	 * @return String
	 */
public String toStringBasic(){
	String cadena="";
	for(int i=0;i<fichas.length; i++){
 		cadena+=fichas[i].getCaracter();
	}
	return cadena;
}
/**
 * 
 * @return LongitudCombinacion
 */
	public int getLength(){
		return this.fichas.length;
	}
	
	/**
	 * 
	 * @return boolean si todo esta en posicion y color igual o no
	 */
	public  boolean esTodoB() {
logger.trace("Miro si todo esta en posicion y color correcto.");
		boolean Ficha=true;
		for (int i = 0; i < fichas.length; i++) {
			if (fichas[i].getCaracter()!='O'){
				Ficha=false;
				break;
			}
		}

		return Ficha;
	}



}

