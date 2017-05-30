package es.unileon.prg1.masterMind;


import org.junit.Assert;
import org.junit.Test;

public class FichaTest {

	Ficha ficha;
	@Test
	public void testPasarCharAColor() throws MasterMindException {
	ficha= new Ficha('R');
	Ficha ficha0= new Ficha('G');
	Ficha ficha1= new Ficha('B');
	Ficha ficha2= new Ficha('P');
	Ficha ficha3= new Ficha('C');
	Ficha ficha4= new Ficha('O');
	Ficha ficha5= new Ficha('Y');
	Ficha ficha6= new Ficha('X');
	Ficha ficha7= new Ficha('-');
	Ficha ficha8= new Ficha('R');
	
	Assert.assertTrue(ficha.compararFicha(ficha8));
	Assert.assertFalse(ficha.compararFicha(ficha4));
	
	Assert.assertEquals(Colors.CYAN, ficha3.getColor());
	
	Assert.assertEquals(Colors.RED, ficha.color());
	Assert.assertEquals(Colors.GREEN, ficha0.color());
	Assert.assertEquals(Colors.BLUE, ficha1.color());
	Assert.assertEquals(Colors.NONE, ficha4.color());
	Assert.assertEquals(Colors.YELLOW, ficha5.color());
	Assert.assertEquals(Colors.NONE, ficha6.color());
	Assert.assertEquals(Colors.NONE, ficha7.color());
	Assert.assertEquals(Colors.PURPLE, ficha2.color());
	Assert.assertEquals(Colors.CYAN, ficha3.color());
	
	Assert.assertEquals('R', ficha.getCaracter());
	
	Assert.assertEquals("R", ficha.getString());
	Assert.assertEquals("G", ficha0.getString());
	Assert.assertEquals("B", ficha1.getString());
	Assert.assertEquals("O", ficha4.getString());
	Assert.assertEquals("Y", ficha5.getString());
	Assert.assertEquals("X", ficha6.getString());
	Assert.assertEquals("-", ficha7.getString());
	Assert.assertEquals("P", ficha2.getString());
	Assert.assertEquals("C", ficha3.getString());
	
	Assert.assertEquals("[31m[R][0m", ficha.toString());
	Assert.assertEquals("[32m[G][0m", ficha0.toString());
	Assert.assertEquals("[34m[B][0m", ficha1.toString());
	Assert.assertEquals("[30m[O][0m", ficha4.toString());
	Assert.assertEquals("[33m[Y][0m", ficha5.toString());
	Assert.assertEquals("[37m[X][0m", ficha6.toString());
	Assert.assertEquals("[30m-[0m", ficha7.toString());
	Assert.assertEquals("[35m[P][0m", ficha2.toString());
	Assert.assertEquals("[36m[C][0m", ficha3.toString());
	}

}
