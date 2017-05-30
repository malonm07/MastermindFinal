package es.unileon.prg1.masterMind;

import org.junit.Assert;
import org.junit.Test;

public class CombinacionTest {
Combinacion combinacion;
	

	@Test
	public void testCombinacion() throws MasterMindException {
		combinacion= new Combinacion("RGB", 3);
		Assert.assertEquals("RGB", combinacion.toStringBasic());
		
	}
	@Test
	public void testEsTodoB() throws MasterMindException {
		combinacion= new Combinacion("OOO", 3);
		Assert.assertTrue(combinacion.esTodoB());
		combinacion= new Combinacion("XOX",3);
		Assert.assertFalse(combinacion.esTodoB());
		
	}
	@Test
	public void testToString() throws MasterMindException {
		combinacion= new Combinacion("RGB", 3);
		Assert.assertEquals("[31m[R][0m[32m[G][0m[34m[B][0m",combinacion.toString());
		
		
	}
	@Test
	public void testCombinacionComparar() throws MasterMindException {
		combinacion= new Combinacion("RGB", 3);
		Combinacion combiIntento=new Combinacion("BGR", 3);
		Combinacion resultante= new Combinacion("OXX",3);
		Combinacion combiIntento2 = new Combinacion("RGB", 3);
		Combinacion resultante2= new Combinacion("OOO", 3);
		Assert.assertEquals(resultante.toStringBasic(), combinacion.comparar(combiIntento).toStringBasic());		
		Assert.assertEquals(resultante2.toStringBasic(), combinacion.comparar(combiIntento2).toStringBasic());		
	}
	@Test (expected = MasterMindException.class)
	public void testCombinacionException() throws MasterMindException{
		combinacion=new Combinacion("RGB",4);
		
	}
	@Test (expected = MasterMindException.class)
	public void testCompararException() throws MasterMindException{
		combinacion=new Combinacion("RGB",3);
		Combinacion combiIntento= new Combinacion("RGBG",4);
		combinacion.comparar(combiIntento);
	}	

	@Test
	public void testGetLength() throws MasterMindException{
		combinacion= new Combinacion("RGB",3);
		
		Assert.assertEquals(3, combinacion.getLength());
	}

}
