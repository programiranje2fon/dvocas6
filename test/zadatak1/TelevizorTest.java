package zadatak1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static ai.fon.bg.ac.rs.test.ReflectionTestUtility.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

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
	public void atribut_nasledjivanje() {
		assertThat(instance, instanceOf(KucniAparat.class));
	}
	
	@Test
	public void atribut_program() {
		try {
			instance.getClass().getDeclaredField("program");
		} catch (NoSuchFieldException e) {
			fail("U klasi nije definisan atribut program");
		}
	}
	
	@Test
	public void atribut_program_vidljivost() {
		int fieldModifiers = getFieldModifier(instance, "program", "U klasi nije definisan atribut program");
		
		assertTrue("Atribut program nije privatan", Modifier.isPrivate(fieldModifiers));
	}
	
	@Test
	public void konstruktor_Televizor() {
		// testing with two different instances in case value of some of the attributes is hard-coded
		Televizor t1 = new Televizor(true, "Samsung UE40", 1);
		boolean ukljucenValue1 = (boolean) getFieldValue(t1, "ukljucen", "U klasi nije definisan atribut ukljucen");
		String markaIModelValue1 = (String) getFieldValue(t1, "markaIModel", "U klasi nije definisan atribut markaIModel");
		int programValue1 = (int) getFieldValue(t1, "program", "U klasi nije definisan atribut program");
		
		assertEquals("Za prosledjeni prvi argument \"true\", atribut ukljucen ima vrednost "+ukljucenValue1, true, ukljucenValue1);
		assertEquals("Za prosledjeni drugi argument \"Samsung UE40\", atribut markaIModel ima vrednost \""+markaIModelValue1+"\"", "Samsung UE40", markaIModelValue1);
		assertEquals("Za prosledjeni treci argument \"1\", atribut program ima vrednost \""+programValue1+"\"", 1, programValue1);
		
		
		// testing with two different instances in case value of some of the attributes is hard-coded
		Televizor t2 = new Televizor(false, "LG OLED65", 40);
		boolean ukljucenValue2 = (boolean) getFieldValue(t2, "ukljucen", "U klasi nije definisan atribut ukljucen");
		String markaIModelValue2 = (String) getFieldValue(t2, "markaIModel", "U klasi nije definisan atribut markaIModel");
		int programValue2 = (int) getFieldValue(t2, "program", "U klasi nije definisan atribut program");
		
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

		assertTrue("NE ispisuje se rec GRESKA u slucaju greske", outContent.toString().trim().equalsIgnoreCase("GRESKA"));
		
		int programValue1 = (int) getFieldValue(t1, "program", "U klasi nije definisan atribut program");
		assertEquals("Za prosledjeni treci argument \"0\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
	}
	
	@Test
	public void konstruktor_Televizor_programMinus1000() {
		Televizor t1 = new Televizor(false, "LG OLED65", -1000);

		assertTrue("NE ispisuje se rec GRESKA u slucaju greske", outContent.toString().trim().equalsIgnoreCase("GRESKA"));
		
		int programValue1 = (int) getFieldValue(t1, "program", "U klasi nije definisan atribut program");
		assertEquals("Za prosledjeni treci argument \"-1000\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
	}
	
	@Test
	public void konstruktor_Televizor_program41() {
		Televizor t1 = new Televizor(false, "LG OLED65", 41);

		assertTrue("NE ispisuje se rec GRESKA u slucaju greske", outContent.toString().trim().equalsIgnoreCase("GRESKA"));
		
		int programValue1 = (int) getFieldValue(t1, "program", "U klasi nije definisan atribut program");
		assertEquals("Za prosledjeni treci argument \"41\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
	}
	
	@Test
	public void konstruktor_Televizor_program1000() {
		Televizor t1 = new Televizor(false, "LG OLED65", 1000);

		assertTrue("NE ispisuje se rec GRESKA u slucaju greske", outContent.toString().trim().equalsIgnoreCase("GRESKA"));
		
		int programValue1 = (int) getFieldValue(t1, "program", "U klasi nije definisan atribut program");
		assertEquals("Za prosledjeni treci argument \"1000\", atribut program ima vrednost \""+programValue1+"\", sto je van granica", 1, programValue1);
	}
	
	@Test
	public void metoda_promeniProgram_parameterUGranicama() {
		instance.promeniProgram(1);
		int programValue1 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"1\" nije postavila atribut \"program\" na tu vrednost", 1, programValue1);
		
		instance.promeniProgram(40);
		int programValue2 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"40\" nije postavila atribut \"program\" na tu vrednost", 40, programValue2);
	}
	
	@Test
	public void metoda_promeniProgram_parameterIspodGranice() {
		int programValue1 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		instance.promeniProgram(0);
		int programValue2 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"0\" ne treba da menja vrednost atributa program", programValue1, programValue2);
		
		int programValue3 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		instance.promeniProgram(-1000);
		int programValue4 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"-1000\" ne treba da menja vrednost atributa program", programValue3, programValue4);
	}
	
	@Test
	public void metoda_promeniProgram_parameterIznadGranice() {
		int programValue1 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		instance.promeniProgram(41);
		int programValue2 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"41\" ne treba da menja vrednost atributa program", programValue1, programValue2);
		
		int programValue3 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		instance.promeniProgram(1000);
		int programValue4 = (int) getFieldValue(instance, "program", "U klasi nije definisan atribut program");
		assertEquals("Metoda promeniProgram(int) sa prosledjenim argumentom \"1000\" ne treba da menja vrednost atributa program", programValue3, programValue4);
	}
	
	@Test
	public void metoda_toString() {
		Televizor t1 = new Televizor(false, "LG OLED65", 15);
		
		assertEquals("Metoda toString ne vraca String u odgovarajucem formatu", "MARKA I MODEL: LG OLED65 UKLJUCEN: false PROGRAM: 15", t1.toString());
	}
	
}
