package zadatak1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;
import zadatak1.KucniAparat;
import zadatak1.Televizor;

public class TelevizorTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	private Televizor instance;

	@Before
	public void setUp() throws Exception {
		instance = new Televizor(true, "Samsung UE40", 1);
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void klasa_nasledjivanje() {
		assertTrue("Klasa Televizor ne nasledjuje klasu KucniAparat", KucniAparat.class.isInstance(instance));
	}
	
	@Test
	public void atribut_program() {
		assertTrue("U klasi nije definisan atribut program", TestUtil.doesFieldExist(Televizor.class, "program"));
	}
	
	@Test
	public void atribut_program_vidljivost() {
		assertTrue("Atribut program nije privatan", TestUtil.hasFieldModifier(Televizor.class, "program", Modifier.PRIVATE));
	}
	
	@Test
	public void konstruktor_Televizor_SamsungUE40() {
		Televizor t1 = new Televizor(true, "Samsung UE40", 1);
		boolean ukljucenValue1 = (boolean) TestUtil.getFieldValue(t1, "ukljucen");
		String markaIModelValue1 = (String) TestUtil.getFieldValue(t1, "markaIModel");
		int programValue1 = (int) TestUtil.getFieldValue(t1, "program");
		
		assertEquals("Za prosledjeni prvi argument \"true\", atribut ukljucen ima vrednost "+ukljucenValue1, true, ukljucenValue1);
		assertEquals("Za prosledjeni drugi argument \"Samsung UE40\", atribut markaIModel ima vrednost \""+markaIModelValue1+"\"", "Samsung UE40", markaIModelValue1);
		assertEquals("Za prosledjeni treci argument \"1\", atribut program ima vrednost \""+programValue1+"\"", 1, programValue1);
	}
	
	@Test
	public void konstruktor_Televizor_LGOLED65() {
		Televizor t2 = new Televizor(false, "LG OLED65", 40);
		boolean ukljucenValue2 = (boolean) TestUtil.getFieldValue(t2, "ukljucen");
		String markaIModelValue2 = (String) TestUtil.getFieldValue(t2, "markaIModel");
		int programValue2 = (int) TestUtil.getFieldValue(t2, "program");
		
		assertEquals("Za prosledjeni prvi argument \"false\", atribut ukljucen ima vrednost "+ukljucenValue2, false, ukljucenValue2);
		assertEquals("Za prosledjeni drugi argument \"LG OLED65\", atribut markaIModel ima vrednost \""+markaIModelValue2+"\"", "LG OLED65", markaIModelValue2);
		assertEquals("Za prosledjeni treci argument \"40\", atribut program ima vrednost \""+programValue2+"\"", 40, programValue2);
	}
	
	/*
	 * test border cases for the attribute program
	 */
	
	@Test
	public void konstruktor_Televizor_program0() {
		Televizor t1 = new Televizor(false, "LG OLED65", 0);

		assertTrue("NE ispisuje se rec GRESKA u slucaju greske", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		
		int programValue1 = (int) TestUtil.getFieldValue(t1, "program");
		assertEquals("Za prosledjeni treci argument \"0\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
	}
	
	@Test
	public void konstruktor_Televizor_programMinus1000() {
		Televizor t1 = new Televizor(false, "LG OLED65", -1000);

		assertTrue("NE ispisuje se rec GRESKA u slucaju greske", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		
		int programValue1 = (int) TestUtil.getFieldValue(t1, "program");
		assertEquals("Za prosledjeni treci argument \"-1000\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
	}
	
	@Test
	public void konstruktor_Televizor_program41() {
		Televizor t1 = new Televizor(false, "LG OLED65", 41);

		assertTrue("NE ispisuje se rec GRESKA u slucaju greske", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		
		int programValue1 = (int) TestUtil.getFieldValue(t1, "program");
		assertEquals("Za prosledjeni treci argument \"41\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
	}
	
	@Test
	public void konstruktor_Televizor_program1000() {
		Televizor t1 = new Televizor(false, "LG OLED65", 1000);

		assertTrue("NE ispisuje se rec GRESKA u slucaju greske", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		
		int programValue1 = (int) TestUtil.getFieldValue(t1, "program");
		assertEquals("Za prosledjeni treci argument \"1000\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
	}
	
	@Test
	public void metoda_promeniProgram_parameterUGranicama1() {
		instance.promeniProgram(1);
		int programValue1 = (int) TestUtil.getFieldValue(instance, "program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"1\" nije postavila atribut program na tu vrednost", 1, programValue1);
	}
	
	@Test
	public void metoda_promeniProgram_parameterUGranicama40() {
		instance.promeniProgram(40);
		int programValue2 = (int) TestUtil.getFieldValue(instance, "program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"40\" nije postavila atribut program na tu vrednost", 40, programValue2);
	}
	
	@Test
	public void metoda_promeniProgram_parameterIspodGranice0() {
		int programValue1 = (int) TestUtil.getFieldValue(instance, "program");
		instance.promeniProgram(0);
		int programValue2 = (int) TestUtil.getFieldValue(instance, "program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"0\" ne treba da menja vrednost atributa program", programValue1, programValue2);
	}
	
	public void metoda_promeniProgram_parameterIspodGraniceMinus1000() {
		int programValue3 = (int) TestUtil.getFieldValue(instance, "program");
		instance.promeniProgram(-1000);
		int programValue4 = (int) TestUtil.getFieldValue(instance, "program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"-1000\" ne treba da menja vrednost atributa program", programValue3, programValue4);
	}
	
	@Test
	public void metoda_promeniProgram_parameterIznadGranice41() {
		int programValue1 = (int) TestUtil.getFieldValue(instance, "program");
		instance.promeniProgram(41);
		int programValue2 = (int) TestUtil.getFieldValue(instance, "program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"41\" ne treba da menja vrednost atributa program", programValue1, programValue2);
	}
	
	@Test
	public void metoda_promeniProgram_parameterIznadGranice1000() {
		int programValue3 = (int) TestUtil.getFieldValue(instance, "program");
		instance.promeniProgram(1000);
		int programValue4 = (int) TestUtil.getFieldValue(instance, "program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"1000\" ne treba da menja vrednost atributa program", programValue3, programValue4);
	}
	
	@Test
	public void metoda_toString() {
		assertTrue("Metoda toString ne vraca vrednost atributa ukljucen", instance.toString().contains("true"));
		assertTrue("Metoda toString ne vraca vrednost atributa markaIModel", instance.toString().toLowerCase().contains("Samsung UE40".toLowerCase()));
		assertTrue("Metoda toString ne vraca vrednost atributa program", instance.toString().contains("1"));
	}
	
}
