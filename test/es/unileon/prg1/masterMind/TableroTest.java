package es.unileon.prg1.masterMind;

import org.junit.Assert;
import org.junit.Test;


public class TableroTest {
	Tablero tablero;
	@Test
	public void testgetIntentos() throws MasterMindException {
		tablero= new Tablero(5,3);	//numINtentos y numFichas
		Combinacion combiIntento= new Combinacion("RGB",3);
		Combinacion combiTestigo= new Combinacion("OOO",3);
		tablero.colocar(combiIntento, combiTestigo);
		Assert.assertEquals("[30m-[0m[30m-[0m[30m-[0m [30m-[0m[30m-[0m[30m-[0m"
+"\n[30m-[0m[30m-[0m[30m-[0m [30m-[0m[30m-[0m[30m-[0m"
+"\n[30m-[0m[30m-[0m[30m-[0m [30m-[0m[30m-[0m[30m-[0m"
+"\n[30m-[0m[30m-[0m[30m-[0m [30m-[0m[30m-[0m[30m-[0m"
+"\n[31m[R][0m[32m[G][0m[34m[B][0m [30m[O][0m[30m[O][0m[30m[O][0m\n", tablero.toString());
		Assert.assertEquals(5, tablero.getIntentos());
	}

	@Test 
	public void testEsTodoCorrecto() throws MasterMindException{
		tablero= new Tablero(5,3);
		Combinacion testigo= new Combinacion("XOO",3);
		Combinacion testigo2 = new Combinacion("OOO",3);
		Assert.assertTrue(tablero.esTodoCorrecto(testigo2));
		Assert.assertFalse(tablero.esTodoCorrecto(testigo));
		
	}
	/*@Test
	public void testComparar() throws MasterMindException{
		Combinacion testigo= new Combinacion("OOO", 3);
		Combinacion testigo2= new Combinacion("XXX",3);
		Combinacion secreta = new Combinacion("RGB",3);
		Combinacion intento= new Combinacion("RGB",3);
		tablero.colocar(intento, testigo);
		Assert.assertEquals(testigo, tablero.comparar(3, secreta));
		Combinacion intento2= new Combinacion("BRG",3);
		tablero.colocar(intento2, testigo2);
		Assert.assertEquals(testigo2, tablero.comparar(3, secreta));
	}*/
}
