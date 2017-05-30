package es.unileon.prg1.masterMind;

import org.junit.Assert;
import org.junit.Test;

public class MastermindTest {

		Mastermind mastermind;
	

	@Test
	public void testColocarCombinacion() throws MasterMindException {
		mastermind= new Mastermind(3,3,true);
		Combinacion intento= new Combinacion("RGB",3);
		Combinacion testigo= new Combinacion("OXX",3);
		Combinacion secreta= new Combinacion("RBG",3);
		mastermind.colocar(intento, testigo);
		mastermind.setCombinacionSecreta(secreta);
		Assert.assertEquals(testigo.toStringBasic(),mastermind.comparar(intento).toStringBasic());
		Assert.assertFalse(mastermind.esTodoCorrecto(intento));
	}

}

