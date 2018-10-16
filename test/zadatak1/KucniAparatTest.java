package zadatak1;

import static ai.fon.bg.ac.rs.test.ReflectionTestUtility.*;
import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ai.fon.bg.ac.rs.test.ReflectionTestUtility;

public class KucniAparatTest {

	KucniAparat instance;

	@Before
	public void setUp() throws Exception {
		instance = new KucniAparat(true, "Laptop Acer A315");
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_ukljucen() {
		getFieldValue(instance, "ukljucen", "U klasi nije definisan atribut ukljucen");
	}
	
	@Test
	public void atribut_ukljucen_vidljivost() {
		int fieldModifiers = getFieldModifier(instance, "ukljucen", "U klasi nije definisan atribut ukljucen");
		
		assertTrue("Atribut ukljucen nije privatan", Modifier.isPrivate(fieldModifiers));
	}
	
	@Test
	public void atribut_markaIModel() {
		try {
			instance.getClass().getDeclaredField("markaIModel");
		} catch (NoSuchFieldException e) {
			fail("U klasi nije definisan atribut markaIModel");
		}
	}
	
	@Test
	public void atribut_markaIModel_vidljivost() {
		int fieldModifiers = getFieldModifier(instance, "markaIModel", "U klasi nije definisan atribut markaIModel");
		
		assertTrue("Atribut markaIModel nije privatan", Modifier.isPrivate(fieldModifiers));
	}
	
	@Test
	public void konstruktor_KucniAparat() {
		// testing with two different instances in case value of some of the attributes is hard-coded
		KucniAparat k1 = new KucniAparat(true, "Laptop Acer A315");
		boolean ukljucenValue1 = (boolean) getFieldValue(k1, "ukljucen", "U klasi nije definisan atribut ukljucen");
		String markaIModelValue1 = (String) getFieldValue(k1, "markaIModel", "U klasi nije definisan atribut markaIModel");
		
		assertEquals("Za prosledjeni prvi argument \"true\", atribut ukljucen ima vrednost "+ukljucenValue1, true, ukljucenValue1);
		assertEquals("Za prosledjeni drugi argument \"Laptop Acer A315\", atribut markaIModel ima vrednost \""+markaIModelValue1+"\"", "Laptop Acer A315", markaIModelValue1);
		
		
		KucniAparat k2 = new KucniAparat(false, "Canon DSLR EOS 5D");
		boolean ukljucenValue2 = (boolean) getFieldValue(k2, "ukljucen", "U klasi nije definisan atribut ukljucen");
		String markaIModelValue2 = (String) getFieldValue(k2, "markaIModel", "U klasi nije definisan atribut markaIModel");
		
		assertEquals("Za prosledjeni prvi argument \"true\", atribut ukljucen ima vrednost "+ukljucenValue2, false, ukljucenValue2);
		assertEquals("Za prosledjeni drugi argument \"Canon DSLR EOS 5D\", atribut markaIModel ima vrednost \""+markaIModelValue2+"\"", "Canon DSLR EOS 5D", markaIModelValue2);
	}
	
	@Test
	public void konstruktor_KucniAparat_vidljivost() {
		int modifiers = getConstructorModifiers(instance, "U klasi nije definisan konstruktor KucniAparat(boolean, String)", new Class[]{boolean.class, String.class});
		
		assertTrue("Konstruktor KucniAparat(boolean, String) nije javan", Modifier.isPublic(modifiers));
	}
	
	@Test
	public void metoda_ukljuciIskljuci() {
		boolean ukljucenValue1 = (boolean) getFieldValue(instance, "ukljucen", "U klasi nije definisan atribut ukljucen");
		instance.ukljuciIskljuci();
		boolean ukljucenValue2 = (boolean) getFieldValue(instance, "ukljucen", "U klasi nije definisan atribut ukljucen");
		assertEquals("Nakon poziva metode ukljuciIskljuci, vrednost se nije promenila sa \""+ukljucenValue1+"\" na \""+!ukljucenValue1+"\"", !ukljucenValue1, ukljucenValue2);
		
		instance.ukljuciIskljuci();
		boolean ukljucenValue3 = (boolean) getFieldValue(instance, "ukljucen", "U klasi nije definisan atribut ukljucen");
		assertEquals("Nakon poziva metode ukljuciIskljuci, vrednost se nije promenila sa \""+ukljucenValue2+"\" na \""+!ukljucenValue2+"\"", !ukljucenValue2, ukljucenValue3);
	}
	
	@Test
	public void metoda_ukljuciIskljuci_vidljivost() {
		int modifiers = ReflectionTestUtility.getMethodModifiers(instance, "ukljuciIskljuci", "U klasi nije definisana metoda ukljuciIskljuci()", new Class[]{});
		
		assertTrue("Metoda ukljuciIskljuci() nije javna", Modifier.isPublic(modifiers));
	}
	
	@Test
	public void metoda_toString() {
		assertEquals("Metoda toString ne vraca String u odgovarajucem formatu", "MARKA I MODEL: Laptop Acer A315 UKLJUCEN: true", instance.toString());
	}
	
	/*
	 *  We don't need to test whether toString() has a public modifier. It has to have since in can not reduce the modifier from the Object class.
	 */
	
	@Test
	public void metoda_equals() {
		assertEquals("Metoda equals ne vraca false ako je prosledjen objekat koji nije KucniAparat", false, instance.equals(new Object()));
		
		// testing with two different instances in case value of the the attribute markaIModel is hard-coded
		KucniAparat k1 = new KucniAparat(true, "Laptop Acer A315");
		KucniAparat k2 = new KucniAparat(true, "Laptop Acer A315");
		assertEquals("Metoda equals ne vraca true kada je pozvana nad kucnim aparatom sa markom i modelom \"Laptop Acer A315\", a prosledjen je kucni aparat sa markom i modelom \"Laptop Acer A315\"", true, k1.equals(k2));
		
		KucniAparat k3 = new KucniAparat(true, "LG OLED65");
		KucniAparat k4 = new KucniAparat(true, "LG OLED65");
		assertEquals("Metoda equals ne vraca true kada je pozvana nad kucnim aparatom sa markom i modelom \"Laptop Acer A315\", a prosledjen je kucni aparat sa markom i modelom \"Laptop Acer A315\"", true, k3.equals(k4));
		
		assertEquals("Metoda equals ne vraca false kada je pozvana nad kucnim aparatom sa markom i modelom \"Laptop Acer A315\", a prosledjen je kucni aparat sa markom i modelom \"LG OLED65\"", false, k1.equals(k3));
	}
	
	/*
	 *  We don't need to test whether equals(Object) has a public modifier. It has to have since in can not reduce the modifier from the Object class.
	 */
	
}
